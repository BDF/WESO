package org.weso.sor.web.pages;

import java.util.Date;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.weso.sor.model.Guardian;
import org.weso.sor.service.GradeList;
import org.weso.sor.utils.StringUtils;
import org.weso.sor.web.AdultTShirtSelectModel;
import org.weso.sor.web.WesoState;
import org.weso.sor.web.YesNoSelectModel;

public class ContactInfoPage  {
	private StringBuilder errorMessages;
	
	@Inject
	@Service("gradeList")
	private GradeList gradeList;
	
	@Component(id="formTest")
	private Form _contactInfoForm;
	
	@ApplicationState
	private WesoState wesoState;

	private AdultTShirtSelectModel adultSizeMode = new AdultTShirtSelectModel();
	private YesNoSelectModel yesNoModel = new YesNoSelectModel();
	private Integer tShirt;
	private Integer tShirtSecondary;
	
	private Integer yesNoPhotos;
	
	@Persist
	private Guardian _guardianOne;
	
	@Persist
	private Guardian _guardianTwo;
	
	@Persist
	private String lastName;
	@Persist
	private String firstName;

	@Persist
	private String primaryEmail;
	@Persist
	private String secondaryEmail;
	@Persist
	private String primaryAreaCode;
	@Persist
	private String primaryPhonePrefix;
	@Persist
	private String primaryLineNumber;
	@Persist
	private String secondaryAreaCode;
	@Persist
	private String secondaryPhonePrefix;
	@Persist
	private String secondaryLineNumber;

	private String primaryAreaCodeSecondary;
	private String primaryPhonePrefixSecondary;
	private String primaryLineNumberSecondary;

	private String secondaryAreaCodeSecondary;

	private String secondaryPhonePrefixSecondary;

	private String secondaryLineNumberSecondary;
	
	public GradeList getGradeList() {
		return gradeList;
	}

	public void setGradeList(GradeList gradeList) {
		this.gradeList = gradeList;
	}
	
	public Guardian getGuardianOne() {
		return _guardianOne;
	}
	
	public void setGuardianOne(Guardian guardian) {
		_guardianOne = guardian;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Validate("required")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setLastNameSecondary(String lastName) {
		_guardianTwo.setLastName(lastName);
	}
	
	public String getLastNameSecondary() {
		return _guardianTwo.getLastName();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	@Validate("required")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstNameSecondary() {
		return _guardianTwo.getFirstName();
	}
	
	public void setFirstNameSecondary(String firstName) {
		_guardianTwo.setFirstName(firstName);
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}
	
	@Validate("required")
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
	

	public String getPrimaryEmailSecondary() {
		return _guardianTwo.getPrimaryEmailAddress();
	}
	
	public void setPrimaryEmailSecondary(String primaryEmail) {
		_guardianTwo.setPrimaryEmailAddress(primaryEmail);
	}
	
	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	
	public String getSecondaryEmailSecondary() {
		return _guardianTwo.getSecondaryEmailAddress();
	}
	
	public void setSecondaryEmailSecondary(String secondaryEmail) {
		_guardianTwo.setSecondaryEmailAddress(secondaryEmail);
	}	
	
	public String getPrimaryAreaCodeSecondary() {
		return primaryAreaCodeSecondary;
	}

	public void setPrimaryAreaCodeSecondary(String primaryAreaCode) {
		primaryAreaCodeSecondary = primaryAreaCode;
	}
	
	public String getPrimaryPhonePrefixSecondary() {
		return primaryPhonePrefixSecondary;
	}
	
	public void setPrimaryPhonePrefixSecondary(String primaryPhonePrefix) {
		this.primaryPhonePrefixSecondary = primaryPhonePrefix;
	}
	public String getPrimaryLineNumberSecondary() {
		return primaryLineNumberSecondary;
	}
	
	public void setPrimaryLineNumberSecondary(String primaryLineNumber) {
		primaryLineNumberSecondary = primaryLineNumber;
	}
	
	public String getSecondaryAreaCodeSecondary() {
		return secondaryAreaCodeSecondary;
	}
	
	public void setSecondaryAreaCodeSecondary(String secondaryAreaCode) {
		secondaryAreaCodeSecondary = secondaryAreaCode;
	}
	
	public String getSecondaryPhonePrefixSecondary() {
		return secondaryPhonePrefixSecondary;
	}
	
	public void setSecondaryPhonePrefixSecondary(String secondaryPhonePrefix) {
		secondaryPhonePrefixSecondary =  secondaryPhonePrefix;
	}
	
	public String getSecondaryLineNumberSecondary() {
		return secondaryLineNumberSecondary;
	}
	
	public void setSecondaryLineNumberSecondary(String secondaryLineNumber) {
		secondaryLineNumberSecondary = secondaryLineNumber;
	}
	
	public String getPrimaryAreaCode() {
		return primaryAreaCode;
	}

	@Validate("required")
	public void setPrimaryAreaCode(String primaryAreaCode) {
		this.primaryAreaCode = primaryAreaCode;
	}
	
	public String getPrimaryPhonePrefix() {
		return primaryPhonePrefix;
	}
	
	@Validate("required")
	public void setPrimaryPhonePrefix(String primaryPhonePrefix) {
		this.primaryPhonePrefix = primaryPhonePrefix;
	}
	public String getPrimaryLineNumber() {
		return primaryLineNumber;
	}
	
	@Validate("required")
	public void setPrimaryLineNumber(String primaryLineNumber) {
		this.primaryLineNumber = primaryLineNumber;
	}
	
	public String getSecondaryAreaCode() {
		return secondaryAreaCode;
	}
	
	public void setSecondaryAreaCode(String secondaryAreaCode) {
		this.secondaryAreaCode = secondaryAreaCode;
	}
	
	public String getSecondaryPhonePrefix() {
		return secondaryPhonePrefix;
	}
	
	
	public void setSecondaryPhonePrefix(String secondaryPhonePrefix) {
		this.secondaryPhonePrefix = secondaryPhonePrefix;
	}
	
	public String getSecondaryLineNumber() {
		return secondaryLineNumber;
	}
	
	
	public void setSecondaryLineNumber(String secondaryLineNumber) {
		this.secondaryLineNumber = secondaryLineNumber;
	}

	
	/**
	 * 
	 */
	Guardian buildGuardianOne() {
		final Guardian guardian = new Guardian();
		final StringUtils utils = new StringUtils();
		final String userName = (new Date()).toString();
		guardian.setUserName(userName);
		guardian.setFirstName(firstName);
		guardian.setLastName(lastName);
		guardian.setPrimaryEmailAddress(primaryEmail);
		final String phone = utils.buildPhone(primaryAreaCode, primaryPhonePrefix, primaryLineNumber);
		guardian.setPrimaryPhoneNumber(phone);
		
		if (yesNoPhotos != null) {
			switch (yesNoPhotos.intValue()) {
			case 0:
			case 1:
				guardian.setPhotoPermisson(true);
				break;
			default:
				guardian.setPhotoPermisson(false);
				break;
			}
		}
		if (secondaryAreaCode != null && secondaryAreaCode.length() > 0) {
			final String secondPhone = utils.buildPhone(secondaryAreaCode, secondaryAreaCode, secondaryLineNumber);
			guardian.setSecondaryPhoneNumber(secondPhone);
		}
		if (secondaryEmail != null && secondaryEmail.length() > 0) {
			guardian.setSecondaryEmailAddress(secondaryEmail);
		}
		
		String tShirtSize = adultSizeMode.findValue(tShirt);
		guardian.setTShirtSize(tShirtSize);

		return guardian;
	}
	
	Guardian buildGuardianTwo() {
		final StringUtils utils = new StringUtils();
		final String phone = utils.buildPhone(
				primaryAreaCodeSecondary, 
				primaryPhonePrefixSecondary, 
				primaryLineNumberSecondary);
		final Guardian guardianTwo = _guardianTwo;
		
		if (utils.hasLength(phone) == false) {
			guardianTwo.setPrimaryPhoneNumber(phone);
		} else {
			guardianTwo.setPrimaryPhoneNumber(_guardianOne.getPrimaryPhoneNumber());
		}
		
		if (utils.hasLength(secondaryLineNumberSecondary)) {
			final String secondPhone = utils.buildPhone(
					secondaryAreaCodeSecondary, 
					secondaryAreaCodeSecondary, 
					secondaryLineNumberSecondary);
			guardianTwo.setSecondaryPhoneNumber(secondPhone);
		}
		final String tShirtSize;
		if (tShirtSecondary != null) {
			tShirtSize = adultSizeMode.findValue(tShirtSecondary);
		} else {
			tShirtSize = "No Shirt";
		}
		guardianTwo.setTShirtSize(tShirtSize);
		
		if (utils.hasLength(guardianTwo.getPrimaryEmailAddress()) == false) {
			String eMailAddr = _guardianOne.getPrimaryEmailAddress();
			guardianTwo.setPrimaryEmailAddress(eMailAddr);
		}

		return guardianTwo;
	}
	
	public void onRenderPage() {
		errorMessages = new StringBuilder();
	}
	
	/**
	 * Tapestry/Web behavior.
	 */
	public String getErrorMessage() {
		String ret = null;
		if (errorMessages != null && errorMessages.length() > 0) {
			ret = errorMessages.toString();
		}
		return ret;
	}
	
//	String attachGuardian() {
//		String resultPage;
//		try {
//			_guardianOne = guardianManager.attachGuardian(userName);
//			resultPage = "Children";
//		} catch (Exception e) {
//			e.printStackTrace();
////			errorMessages = "Internal Error, please contact Brian Forester";
//			resultPage = "ContactInfoPage";
//		}
//		return resultPage;
//	}
	
	public SelectModel getTShirtSizes() {
		return adultSizeMode;
	}
	
	@Validate("required")
	public void setTShirt(Integer tShirtSize) {
		tShirt = tShirtSize;
	}

	public Integer getTShirt() {
		return tShirt;
	}
	
	public void setTShirtSecondary(Integer tShirtSize) {
		tShirtSecondary = tShirtSize;
	}

	public Integer getTShirtSecondary() {
		return tShirtSecondary;
	}
	
	public SelectModel getYesNoModel() {
		return yesNoModel;
	}

	public Integer getYesNoPhotos() {
		return yesNoPhotos;
	}

	@Validate("required")
	public void setYesNoPhotos(Integer yesNoPhotos) {
		this.yesNoPhotos = yesNoPhotos;
	}
	
	public void onValidateForm() {
		if (yesNoPhotos == null || yesNoModel.findValue(yesNoPhotos).equals("")){
			_contactInfoForm.recordError("Yes/No required for photography permission");
		}
		final StringUtils utils = new StringUtils();
		int count = 0;
		if (utils.hasLength(_guardianTwo.getFirstName())) {
			count++;
		}
		if (utils.hasLength(_guardianTwo.getLastName())) {
			count++;
		}
		
		if (count > 0 && count < 2) {
			_contactInfoForm.recordError(
					"Please set first name and last name parent two or clear the fields.");
		}
	}

	public String onSuccess() {
		String resultPage = "ContactInfoPage";
		
		try {
			final StringUtils utils = new StringUtils();
			final Guardian guardian = buildGuardianOne();
//			_guardianOne = guardianManager.addGuardian(guardian);
			if (utils.hasLength(_guardianTwo.getFirstName()) &&
				utils.hasLength(_guardianTwo.getLastName()) &&
				utils.hasLength(primaryLineNumberSecondary) &&
				_guardianTwo.getGuardianId() == null) {
				_guardianTwo = buildGuardianTwo();
				wesoState.setGuardianTwo(_guardianTwo);
			}
			wesoState.setGuardianOne(guardian);

			resultPage = "VolunteerPage";
		} catch (Exception e) {
			e.printStackTrace();
			resultPage = "ContactInfoPage";
		}

		return resultPage;
	}
	
	public Object onActivate() {
		if (wesoState == null) {
			return StudentPage.class;
		}
		if (wesoState.getGuardianTwo() != null) {
			_guardianTwo = wesoState.getGuardianTwo();
		} else {
			_guardianTwo = new Guardian();
		}
		
		return null;
	}

}
