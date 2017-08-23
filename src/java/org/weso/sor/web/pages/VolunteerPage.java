package org.weso.sor.web.pages;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.weso.sor.model.GuardianVolunteerChoices;
import org.weso.sor.model.VolunteerActivities;
import org.weso.sor.service.VolunteerManager;
import org.weso.sor.web.VolunteerRanking;
import org.weso.sor.web.WesoState;

public class VolunteerPage {
	@Property
	private String errorMessage;

	@Inject
	@Service("volunteerManager")
	private VolunteerManager vaManager;

	private Map<String, VolunteerActivities> volActivies = new HashMap<String, VolunteerActivities>();

	@ApplicationState
	private WesoState wesoState;

	@Property
	private VolunteerRanking banquetCleanupOneChoice;
	@Property
	private VolunteerRanking banquetCleanupTwoChoice;
	@Property
	private VolunteerRanking banquetSetupOneChoice;
	@Property
	private VolunteerRanking banquetSetupTwoChoice;
	@Property
	private VolunteerRanking eventAndAssistentCoachOneChoice;
	@Property
	private VolunteerRanking eventAndAssistentCoachTwoChoice;
	@Property
	private VolunteerRanking eventDayAfterOneChoice;
	@Property
	private VolunteerRanking eventDayAfterTwoChoice;
	@Property
	private VolunteerRanking eventDayMorningOneChoice;
	@Property
	private VolunteerRanking eventDayMorningTwoChoice;
	@Property
	private VolunteerRanking homeroomFunOneChoice;
	@Property
	private VolunteerRanking homeroomFunTwoChoice;
	@Property
	private VolunteerRanking homeroomCleanOneChoice;
	@Property
	private VolunteerRanking homeroomCleanTwoChoice;
	@Property
	private VolunteerRanking homeroomCopyingOneChoice;
	@Property
	private VolunteerRanking homeroomCopyingTwoChoice;
	@Property
	private VolunteerRanking homeroomCreationOneChoice;
	@Property
	private VolunteerRanking homeroomCreationTwoChoice;
	@Property
	private VolunteerRanking homeroomParentOneChoice;
	@Property
	private VolunteerRanking homeroomParentTwoChoice;
	@Property
	private VolunteerRanking homeroomSetOneChoice;
	@Property
	private VolunteerRanking homeroomSetTwoChoice;
	@Property
	private VolunteerRanking lakewoodBannerOneChoice;
	@Property
	private VolunteerRanking lakewoodBannerTwoChoice;
	@Property
	private VolunteerRanking nametagsOneChoice;
	@Property
	private VolunteerRanking nametagsTwoChoice;
	@Property
	private VolunteerRanking catcherOneChoice;
	@Property
	private VolunteerRanking catcherTwoChoice;
	@Property
	private VolunteerRanking bookletOneChoice;
	@Property
	private VolunteerRanking bookletTwoChoice;
	@Property
	private VolunteerRanking tShirtsOneChoice;
	@Property
	private VolunteerRanking tShirtsTwoChoice;
	@Property
	private VolunteerRanking wesoHelperOneChoice;
	@Property
	private VolunteerRanking wesoHelperTwoChoice;

	public VolunteerRanking getYes() {
		return VolunteerRanking.Yes;
	}

	public VolunteerRanking getNo() {
		return VolunteerRanking.No;
	}

	public VolunteerRanking getOK() {
		return VolunteerRanking.OK;
	}

	public void pageLoad() {
		volActivies = vaManager.loadNameToVolunteerActivities();
	}
	
	public void onPageLoad() {
		volActivies = vaManager.loadNameToVolunteerActivities();
	}

	public String onSuccess() {
		if (volActivies.size() == 0) {
			volActivies = vaManager.loadNameToVolunteerActivities(); 
		}
		
		final Set<GuardianVolunteerChoices> gOneVols = new HashSet<GuardianVolunteerChoices>();
		final Set<GuardianVolunteerChoices> gTwoVols = new HashSet<GuardianVolunteerChoices>();

		final String[] names = { "Celebration Banquet Clean Up",
				"Celebration Banquet Set Up", "Event and Assistant Coaches",
				"Event Day Photographer(Afternoon)",
				"Event Day Photographer(Morning)", "Homeroom Clean Up",
				"Homeroom Handouts Copying", "Homeroom Handouts Creation",
				"Homeroom Parent", "Homeroom Set Up",
				"Homeroom Student Fun Handouts Creation", "Lakewood Banner",
				"Student Catcher at Non-Spectator Events Wing Exit",
				"Student Name Tags and Best Banner Voting Ballet",
				"Team Photograph and Booklet Page", "Team T-Shirts",
				"WESO helper" };

		final VolunteerRanking[] volRankings = { banquetCleanupOneChoice,
				banquetSetupOneChoice, eventAndAssistentCoachOneChoice,
				eventDayAfterOneChoice, eventDayMorningOneChoice,
				homeroomCleanOneChoice, homeroomCopyingOneChoice,
				homeroomCreationOneChoice, homeroomParentOneChoice,
				homeroomSetOneChoice, homeroomFunOneChoice,
				lakewoodBannerOneChoice, catcherOneChoice, nametagsOneChoice,
				bookletOneChoice, tShirtsOneChoice, wesoHelperOneChoice };

		final VolunteerRanking[] volRankings2 = { banquetCleanupTwoChoice,
				banquetSetupTwoChoice, eventAndAssistentCoachTwoChoice,
				eventDayAfterTwoChoice, eventDayMorningTwoChoice,
				homeroomCleanTwoChoice, homeroomCopyingTwoChoice,
				homeroomCreationTwoChoice, homeroomParentTwoChoice,
				homeroomSetTwoChoice, homeroomFunTwoChoice,
				lakewoodBannerTwoChoice, catcherTwoChoice, nametagsTwoChoice,
				bookletTwoChoice, tShirtsTwoChoice, wesoHelperTwoChoice };

		for (int x = 0; x < volRankings.length; x++) {
			addVolunteerActivityToChoices(gOneVols, names[x], volRankings[x]);
		}
		
		if (wesoState.getGuardianTwo() != null) {
			for (int x = 0; x < volRankings.length; x++) {
				addVolunteerActivityToChoices(gTwoVols, names[x], volRankings2[x]);
			}	
		}
		
		wesoState.setVolunteerOne(gOneVols);
		wesoState.setVolunteerTwo(gTwoVols);

		return "ConfirmationPage";
	}

	private void addVolunteerActivityToChoices(
			final Set<GuardianVolunteerChoices> gOneVols,
			final String activityName, final VolunteerRanking volunteerRanking) {
		if (volunteerRanking != null && volunteerRanking.equals(VolunteerRanking.No) == false) {
			final VolunteerActivities va = volActivies.get(activityName);
			if (va == null) {
				System.out.println("wtf");
			}
			final GuardianVolunteerChoices gvc = new GuardianVolunteerChoices();
			gvc.setVolunteerActivities(va);
			gvc.setRanking(volunteerRanking.ordinal());
			gOneVols.add(gvc);
		}
	}

}

/**
 * 
 * addVolunteerActivityToChoices(gOneVols, "Celebration Banquet Clean Up",
 * banquetCleanupOneChoice);
 * 
 * if (banquetSetupOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (eventAndAssistentCoachOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (eventDayAfterOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (eventDayMorningOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (homeroomFunOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (homeroomCleanOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (homeroomCopyingOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (homeroomCreationOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (homeroomParentOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (homeroomSetOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (lakewoodBannerOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (nametagsOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (catcherOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (bookletOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (tShirtsOneChoice.equals(VolunteerRanking.No) == false) { } if
 * (wesoHelperOneChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (wesoHelperTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (banquetCleanupTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (banquetSetupTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (eventAndAssistentCoachTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (eventDayAfterTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (eventDayMorningTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (homeroomFunTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (homeroomCleanTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (homeroomCopyingTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (homeroomCreationTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (homeroomParentTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (homeroomSetTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (lakewoodBannerTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (nametagsTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (catcherTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (bookletTwoChoice.equals(VolunteerRanking.No) == false) { }
 * 
 * if (tShirtsTwoChoice.equals(VolunteerRanking.No) == false) { }
 */
