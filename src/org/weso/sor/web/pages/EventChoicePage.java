package org.weso.sor.web.pages;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.PageAttached;
import org.apache.tapestry5.annotations.PageDetached;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.weso.sor.model.Events;
import org.weso.sor.model.Student;
import org.weso.sor.model.StudentEventChoices;
import org.weso.sor.model.Teacher;
import org.weso.sor.service.EventChoiceList;
import org.weso.sor.service.TeachersList;
import org.weso.sor.utils.Counter;
import org.weso.sor.web.NumberOfEvents;
import org.weso.sor.web.Ranking;
import org.weso.sor.web.TeachersSelectModel;
import org.weso.sor.web.WesoState;

public class EventChoicePage {
	@Inject
	@Service("teacherList")
	private TeachersList teacherList;

	@Inject
	@Service("eventChoiceList")
	private EventChoiceList eventChoiceList;

	@Persist
	private NumberOfEvents numberOfEvents;

	@ApplicationState
	private WesoState wesoState;

	@Component(id = "eventChoicePageId")
	private Form _form;

	private TeachersSelectModel teachersSelectModel;
	private String errorMessage = "";
	@Persist
	private Integer selectedTeacher;
	private Events event;
	
	private String nextPage;

	@SuppressWarnings("unused")
	@Property
	private boolean isSecondGrade;
	@SuppressWarnings("unused")
	@Property
	private boolean isThirdGrade;
	@SuppressWarnings("unused")
	@Property
	private boolean isFourthGrade;
	@SuppressWarnings("unused")
	@Property
	private boolean isFifthGrade;

	@Property
	@Persist
	private Ranking anatomyChoice;

	@Property
	@Persist
	private Boolean _anatomyAlt;

	@Persist
	@Property
	private Ranking bargeChoice;
	
	@Property
	@Persist
	private Boolean _bargeAlt;

	@Persist
	@Property
	private Ranking chopperChallenge;
	
	@Property
	@Persist
	private Boolean _chopperAlt;

	@Persist
	@Property
	private Ranking circuitWizardy;

	@Property
	@Persist
	private Boolean _circuitAlt;
	
	@Persist
	@Property
	private Ranking mapReading;
	
	@Property
	@Persist
	private Boolean _mapAlt;
	
	@Persist
	@Property
	private Ranking monsterMatch;

	@Property
	@Persist
	private Boolean _monsterAlt;
	
	@Persist
	@Property
	private Ranking mystArch;

	@Property
	@Persist
	private Boolean _mystAlt;
	
	@Persist
	@Property
	private Ranking pentaChoice;

	@Property
	@Persist
	private Boolean _pentaAlt;
	
	@Persist
	@Property
	private Ranking puffChoice;

	@Property
	@Persist
	private Boolean _puffAlt;
	
	@Persist
	@Property
	private Ranking rockChoice;

	@Property
	@Persist
	private Boolean _rockAlt;
	
	@Persist
	@Property
	private Ranking scienceJeopardy;

	@Property
	@Persist
	private Boolean _scienceAlt;
	
	@Persist
	@Property
	private Ranking sinkOrFloat;
	
	@Property
	@Persist
	private Boolean _sinkAlt;

	@Persist
	@Property
	private Ranking strawTower;

	@Property
	@Persist
	private Boolean _strawAlt;
	
	@Persist
	@Property
	private Ranking waterRockets;

	@Property
	@Persist
	private Boolean _waterAlt;
	
	@Persist
	@Property
	private Ranking whatWentBy;

	@Property
	@Persist
	private Boolean _whatAlt;
	
	@Persist
	@Property
	private Ranking writeItBuildIt;

	@Property
	@Persist
	private Boolean _writeAlt;
	
	@Persist
	@Property
	private Ranking estimChoice;
	
	@Property
	@Persist
	private Boolean _estimAlt;
	
	@Persist
	@Property
	private Ranking tbdChoice;

	@Property
	@Persist
	private Boolean _tbdAlt;
	
	public EventChoicePage() {
	}

	public Integer getTeacher() {
		return selectedTeacher;
	}

	public void setTeacher(Integer selectedTeacher) {
		this.selectedTeacher = selectedTeacher;
	}

	public Events getEvent() {
		return event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}

	public NumberOfEvents getNumberOfEvents() {
		return numberOfEvents;
	}

	public void setNumberOfEvents(NumberOfEvents numberOfEvents) {
		this.numberOfEvents = numberOfEvents;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public SelectModel getTeachers() {
		return teachersSelectModel;
	}

	protected void fillTeachersModel() {
		final List<Teacher> tempTSM;
		if (wesoState != null && wesoState.getCurrentStudent() != null
				&& wesoState.getCurrentStudent().getGrade() != null) {
			tempTSM = teacherList.getTeachers(wesoState.getCurrentStudent()
					.getGrade().getGradeId());
			teachersSelectModel = new TeachersSelectModel(tempTSM);
		}
	}

	public void onPrepareForRender() {
	}

	public void pageAttach() {
		// System.out.println("pageAttach  Lookup teacher for:  " +
		// wesoState.getNewStudent());
	}

	public Object onActivate() {
		final Class<?> retPage;
		if (wesoState == null) {
			retPage = StudentPage.class;
		} else if (wesoState.getCurrentStudent() == null) {
			retPage = StudentPage.class;
		} else {
			final int gradeNum = wesoState.getCurrentStudent().getGrade()
					.getGradeNumb();
			
			fillTeachersModel();
			isSecondGrade = (gradeNum == 2);
			isThirdGrade = (gradeNum == 3);
			isFourthGrade = (gradeNum == 4);
			isFifthGrade = (gradeNum == 5);
			retPage = null;
		}
		return retPage;
	}

	public Ranking getFirst() {
		return Ranking.First;
	}

	public Ranking getSecond() {
		return Ranking.Second;
	}

	public Ranking getThird() {
		return Ranking.Third;
	}

	public Ranking getFourth() {
		return Ranking.Fourth;
	}

	public Ranking getFifth() {
		return Ranking.Fifth;
	}

	public Ranking getOK() {
		return Ranking.OK;
	}

	public Ranking getNo() {
		return Ranking.No;
	}

	public void pageDetached() {
		anatomyChoice = null;
		bargeChoice = null;
		chopperChallenge = null;
		circuitWizardy = null;
		mapReading = null;
		monsterMatch = null;
		mystArch = null;
		pentaChoice = null;
		puffChoice = null;
		rockChoice = null;
		scienceJeopardy = null;
		sinkOrFloat = null;
		strawTower = null;
		waterRockets = null;
		whatWentBy = null;
		writeItBuildIt = null;
		estimChoice = null;
		tbdChoice = null;
	}

	public WesoState getWesoState() {
		return wesoState;
	}

	public void setWesoState(WesoState wesoState) {
		this.wesoState = wesoState;
	}

	public Object onSuccess() {
		int grade = wesoState.getCurrentStudent().getGrade().getGradeNumb();
		
		Map<String, Ranking> nameToEventRanking = new HashMap<String, Ranking>();
		Map<String, Events>	 nameToEvents = new HashMap<String, Events>();
		List<Events> allEvents = eventChoiceList.loadEventsByGrade(grade);
		
		for (Events events : allEvents) {
			nameToEvents.put(events.getEventName(), events);
		}
		nameToEventRanking.put("A is for Anatomy",  this.anatomyChoice);
		nameToEventRanking.put("Barge Building",  this.bargeChoice);
		nameToEventRanking.put("Chopper Challenge",  this.chopperChallenge);
		nameToEventRanking.put("Circuit Wizardry",  this.circuitWizardy);
		nameToEventRanking.put("Estimania",  this.estimChoice);
		nameToEventRanking.put("Map Reading",  this.mapReading);
		nameToEventRanking.put("Monster Match",  this.monsterMatch);
		nameToEventRanking.put("Mystery Architecture",  this.mystArch);
		nameToEventRanking.put("Pentathlon",  this.pentaChoice);
		nameToEventRanking.put("Puff Mobiles",  this.puffChoice);
		nameToEventRanking.put("Rock Hound",  this.rockChoice);
		nameToEventRanking.put("Science Jeopardy",  this.scienceJeopardy);
		nameToEventRanking.put("Sink or Float",  this.sinkOrFloat);
		nameToEventRanking.put("Straw Tower",  this.strawTower);
		nameToEventRanking.put("Water Rockets",  this.waterRockets);
		nameToEventRanking.put("What Went By",  this.whatWentBy);
		nameToEventRanking.put("Write It, Build It",  this.writeItBuildIt);
		nameToEventRanking.put("Potions",  this.tbdChoice);

		final Student curStudent = wesoState.getCurrentStudent();
		final Teacher teacher = teacherList.loadTeacher(selectedTeacher);
		curStudent.setNumberOfEvents(numberOfEvents.findNumberOfEvents());
		curStudent.setTeacher(teacher);
		curStudent.setDateCreated(new Date());
		curStudent.setNumberOfEvents(this.numberOfEvents.findNumberOfEvents());
		
		Set<String> eventNameSet = nameToEventRanking.keySet();
		List<StudentEventChoices> eventStatusList = new ArrayList<StudentEventChoices>();
		for (String eventName : eventNameSet) {
			Ranking ranking = nameToEventRanking.get(eventName);
			if (ranking != null) {
				Events event = nameToEvents.get(eventName);
				StudentEventChoices sec = new StudentEventChoices();
				if (event == null || event.getEventName() == null || event.getEventName().length() == 0) {
					System.out.println("Error ");
				}
				sec.setEvents(event);
				sec.setRanking(ranking.ordinal());
				eventStatusList.add(sec);
			}
		}
		

//		curStudent.setNonStudentEventChoices(eventStatusList);
//		studentManager.addStudent(curStudent, eventStatusList);
		wesoState.addStudentEventChoices(curStudent, eventStatusList);
		wesoState.finishCurrentStudent();

		return nextPage;
	}

	public void onValidateForm() {
		Map<Ranking, Counter> rankings = new HashMap<Ranking, org.weso.sor.utils.Counter>();
		for (int x = 0; x < Ranking.values().length; x++) {
			rankings.put(Ranking.values()[x], new Counter());
		}
		List<Ranking> rankingByEvent = new ArrayList<Ranking>();
		final int gradeNum = wesoState.getCurrentStudent().getGrade().getGradeNumb();
		switch (gradeNum) {
		case 2:
			rankingByEvent.add(anatomyChoice);
			rankingByEvent.add(bargeChoice);
			rankingByEvent.add(estimChoice);
			rankingByEvent.add(mapReading);
			rankingByEvent.add(monsterMatch);
			rankingByEvent.add(mystArch);
			rankingByEvent.add(pentaChoice);
			rankingByEvent.add(puffChoice);
			rankingByEvent.add(rockChoice);
			rankingByEvent.add(sinkOrFloat);
			rankingByEvent.add(whatWentBy);
			break;
		case 3:
			rankingByEvent.add(anatomyChoice);
			rankingByEvent.add(estimChoice);
			rankingByEvent.add(mapReading);
			rankingByEvent.add(mystArch);
			rankingByEvent.add(pentaChoice);
			rankingByEvent.add(puffChoice);
			rankingByEvent.add(rockChoice);
			rankingByEvent.add(strawTower);
			rankingByEvent.add(waterRockets);
			rankingByEvent.add(whatWentBy);
			rankingByEvent.add(writeItBuildIt);
			break;
		case 4:
			rankingByEvent.add(anatomyChoice);
			rankingByEvent.add(circuitWizardy);
			rankingByEvent.add(chopperChallenge);
			rankingByEvent.add(estimChoice);
			rankingByEvent.add(mapReading);
			rankingByEvent.add(mystArch);
			rankingByEvent.add(pentaChoice);
			rankingByEvent.add(rockChoice);
			rankingByEvent.add(scienceJeopardy);
			rankingByEvent.add(strawTower);
			rankingByEvent.add(waterRockets);
			rankingByEvent.add(writeItBuildIt);
			rankingByEvent.add(tbdChoice);
			break;
		case 5:
			rankingByEvent.add(anatomyChoice);
			rankingByEvent.add(circuitWizardy);
			rankingByEvent.add(chopperChallenge);
			rankingByEvent.add(estimChoice);
			rankingByEvent.add(mapReading);
			rankingByEvent.add(mystArch);
			rankingByEvent.add(pentaChoice);
			rankingByEvent.add(rockChoice);
			rankingByEvent.add(scienceJeopardy);
			rankingByEvent.add(strawTower);
			rankingByEvent.add(waterRockets);
			rankingByEvent.add(writeItBuildIt);
			rankingByEvent.add(tbdChoice);
			break;
		}
		boolean foundUnselected = false;
		for (Ranking ranking : rankingByEvent) {
			if (ranking == null) { 
				if (foundUnselected == false) {
					_form.recordError("All Events must have One Choice.");
					foundUnselected = true;
				}
			} else {
				ranking.addToRank(rankings);
			}
		}
		
		if (selectedTeacher == null) {
			_form.recordError("You must select a teacher.");
		}
		
		for (int x = 0; x < Ranking.values().length; x++) {
			final Ranking key = Ranking.values()[x];
			Counter num = rankings.get(key);
			if (num.getCount() != 1 && (key != Ranking.OK && key != Ranking.No)) {
				_form.recordError("You must have one event as your " + key.toString() + " choice");
			}
		}
	}

	@PageAttached
	public void initPage() {
		numberOfEvents = NumberOfEvents.Three;
	}

	@PageDetached
	public void pageBackToPool() {
		
	}
	
	void onSelectedFromAddStudent() {
		wesoState.setAddingStudent(true);
		nextPage = "StudentPage";
	}

	void onSelectedFromContactInfo() {
		wesoState.setAddingStudent(false);
		nextPage = "ContactInfoPage";
	}
}
