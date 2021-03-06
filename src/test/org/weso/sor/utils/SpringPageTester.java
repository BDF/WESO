package org.weso.sor.utils;

import static org.apache.tapestry5.ioc.internal.util.CollectionFactory.newMap;
import static org.apache.tapestry5.ioc.internal.util.Defense.notNull;

import java.util.Locale;
import java.util.Map;

import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.dom.Node;
import org.apache.tapestry5.internal.InternalConstants;
import org.apache.tapestry5.internal.SingleKeySymbolProvider;
import org.apache.tapestry5.internal.TapestryAppInitializer;
import org.apache.tapestry5.internal.services.ComponentEventTarget;
import org.apache.tapestry5.internal.services.ComponentInvocation;
import org.apache.tapestry5.internal.services.ComponentInvocationImpl;
import org.apache.tapestry5.internal.services.ComponentInvocationMap;
import org.apache.tapestry5.internal.services.LocalizationSetter;
import org.apache.tapestry5.internal.services.PageRenderTarget;
import org.apache.tapestry5.internal.spring.SpringModuleDef;
import org.apache.tapestry5.internal.test.ComponentEventInvoker;
import org.apache.tapestry5.internal.test.ComponentInvoker;
import org.apache.tapestry5.internal.test.PageRenderInvoker;
import org.apache.tapestry5.internal.test.PageTesterContext;
import org.apache.tapestry5.internal.test.PageTesterModule;
import org.apache.tapestry5.internal.test.TestableRequest;
import org.apache.tapestry5.ioc.Registry;
import org.apache.tapestry5.ioc.def.ModuleDef;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.ioc.util.StrategyRegistry;
import org.apache.tapestry5.services.ApplicationGlobals;
import org.apache.tapestry5.services.ContextPathEncoder;
import org.springframework.context.ApplicationContext;

public class SpringPageTester  implements ComponentInvoker
{
    private final Registry registry;

    private final ComponentInvocationMap invocationMap;

    private final TestableRequest request;

    private final StrategyRegistry<ComponentInvoker> invokerRegistry;

    private final LocalizationSetter localizationSetter;

    private final ContextPathEncoder contextPathEncoder;

    private Locale preferedLanguage;

    public static final String DEFAULT_CONTEXT_PATH = "src/main/webapp";

    private static final String DEFAULT_SUBMIT_VALUE_ATTRIBUTE = "Submit Query";


    /**
     * Initializes a PageTester that acts as a browser and a servlet container to test drive your Tapestry pages.
     *
     * @param appPackage    The same value you would specify using the tapestry.app-package context parameter. As this
     *                      testing environment is not run in a servlet container, you need to specify it.
     * @param appName       The same value you would specify as the filter name. It is used to form the name of the
     *                      module builder for your app. If you don't have one, pass an empty string.
     * @param contextPath   The path to the context root so that Tapestry can find the templates (if they're put
     *                      there).
     * @param moduleClasses Classes of additional modules to load
     */
    @SuppressWarnings("unchecked")
    public SpringPageTester(
    		String appPackage, 
    		String appName, 
    		String contextPath, 
    		ApplicationContext ac, Class... moduleClasses)
    {
        preferedLanguage = Locale.ENGLISH;

        SymbolProvider provider = new SingleKeySymbolProvider(InternalConstants.TAPESTRY_APP_PACKAGE_PARAM, appPackage);

        TapestryAppInitializer initializer = new TapestryAppInitializer(provider, appName, PageTesterModule.TEST_MODE);

        initializer.addModules(PageTesterModule.class);
        initializer.addModules(moduleClasses);
        initializer.addModules(provideExtraModuleDefs());
        initializer.addModules(new SpringModuleDef(ac));
        
        registry = initializer.getRegistry();

        request = registry.getObject(TestableRequest.class, null);

        localizationSetter = registry.getService("LocalizationSetter", LocalizationSetter.class);

        invocationMap = registry.getObject(ComponentInvocationMap.class, null);

        ApplicationGlobals globals = registry.getObject(ApplicationGlobals.class, null);

        globals.storeContext(new PageTesterContext(contextPath));

        Map<Class, ComponentInvoker> map = newMap();

        map.put(PageRenderTarget.class, new PageRenderInvoker(registry, this, invocationMap));

        map.put(ComponentEventTarget.class, new ComponentEventInvoker(registry, this, invocationMap));

        invokerRegistry = StrategyRegistry.newInstance(ComponentInvoker.class, map);

        contextPathEncoder = registry.getService(ContextPathEncoder.class);
    }

    /**
     * Overridden in subclasses to provide additional module definitions beyond those normally located. This
     * implementation returns an empty array.
     */
    protected ModuleDef[] provideExtraModuleDefs()
    {
        return new ModuleDef[0];
    }


    /**
     * You should call it after use
     */
    public void shutdown()
    {
        registry.shutdown();
    }


    /**
     * Returns the Registry that was created for the application.
     */
    public Registry getRegistry()
    {
        return registry;
    }

    /**
     * Allows a service to be retrieved via its service interface.  Use {@link #getRegistry()} for more complicated
     * queries.
     *
     * @param serviceInterface used to select the service
     */
    public <T> T getService(Class<T> serviceInterface)
    {
        return registry.getService(serviceInterface);
    }

    /**
     * Renders a page specified by its name.
     *
     * @param pageName The name of the page to be rendered.
     * @return The DOM created. Typically you will assert against it.
     */
    public Document renderPage(String pageName)
    {
        return invoke(
                new ComponentInvocationImpl(contextPathEncoder, new PageRenderTarget(pageName), null, null, false));
    }

    /**
     * Simulates a click on a link.
     *
     * @param link The Link object to be "clicked" on.
     * @return The DOM created. Typically you will assert against it.
     */
    public Document clickLink(Element link)
    {
        notNull(link, "link");

        ComponentInvocation invocation = getInvocation(link);

        return invoke(invocation);
    }

    private ComponentInvocation getInvocation(Element element)
    {
        ComponentInvocation invocation = invocationMap.get(element);

        if (invocation == null)
            throw new IllegalArgumentException("No component invocation object is associated with the Element.");

        return invocation;
    }

    public Document invoke(ComponentInvocation invocation)
    {
        // It is critical to clear the map before invoking an invocation (render a page or click a
        // link).
        invocationMap.clear();

        setThreadLocale();

        ComponentInvoker invoker = invokerRegistry.getByInstance(invocation.getTarget());

        return invoker.invoke(invocation);
    }

    private void setThreadLocale()
    {
        localizationSetter.setThreadLocale(preferedLanguage);
    }

    /**
     * Simulates a submission of the form specified. The caller can specify values for the form fields.
     *
     * @param form       the form to be submitted.
     * @param parameters the query parameter name/value pairs
     * @return The DOM created. Typically you will assert against it.
     */
    public Document submitForm(Element form, Map<String, String> parameters)
    {
        notNull(form, "form");

        request.clear();

        request.loadParameters(parameters);

        addHiddenFormFields(form);

        ComponentInvocation invocation = getInvocation(form);

        return invoke(invocation);
    }

    /**
     * Simulates a submission of the form by clicking the specified submit button. The caller can specify values for the
     * form fields.
     *
     * @param submitButton the submit button to be clicked.
     * @param fieldValues  the field values keyed on field names.
     * @return The DOM created. Typically you will assert against it.
     */
    public Document clickSubmit(Element submitButton, Map<String, String> fieldValues)
    {
        notNull(submitButton, "submitButton");

        assertIsSubmit(submitButton);

        Element form = getFormAncestor(submitButton);
        String value = submitButton.getAttribute("value");

        if (value == null) value = DEFAULT_SUBMIT_VALUE_ATTRIBUTE;

        fieldValues.put(submitButton.getAttribute("name"), value);

        return submitForm(form, fieldValues);
    }

    private void assertIsSubmit(Element element)
    {
        if (element.getName().equals("input"))
        {
            String type = element.getAttribute("type");

            if ("submit".equals(type)) return;
        }

        throw new IllegalArgumentException("The specified element is not a submit button.");
    }

    private Element getFormAncestor(Element element)
    {
        while (true)
        {
            if (element == null) throw new IllegalArgumentException("The given element is not contained by a form.");

            if (element.getName().equalsIgnoreCase("form")) return element;

            element = element.getParent();
        }
    }

    private void addHiddenFormFields(Element element)
    {
        if (isHiddenFormField(element))
            request.loadParameter(element.getAttribute("name"), element.getAttribute("value"));

        for (Node child : element.getChildren())
        {
            if (child instanceof Element)
            {
                addHiddenFormFields((Element) child);
            }
        }
    }

    private boolean isHiddenFormField(Element element)
    {
        return element.getName().equalsIgnoreCase("input") && "hidden".equalsIgnoreCase(element.getAttribute("type"));
    }

    public void setPreferedLanguage(Locale preferedLanguage)
    {
        this.preferedLanguage = preferedLanguage;
    }
}