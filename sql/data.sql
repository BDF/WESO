use weso;

delete from event_to_grade;
delete from teacher_To_Grade;
delete from grade;
delete from teacher;
delete from events;
delete from volunteer_Activities;

insert into grade(grade_numb, grade_desc)
  		values(2, "Second Grade");
  		
insert into grade(grade_numb, grade_desc)
  		values(3, "Third Grade");
  		
insert into grade(grade_numb, grade_desc)
  		values(4, "Fourth Grade");
  		
insert into grade(grade_numb, grade_desc)
  		values(5, "Fifth Grade");

insert into teacher (teacher_name) values("Cooper");
insert into teacher (teacher_name) values("Copes");
insert into teacher (teacher_name) values("Taylor");

insert into teacher (teacher_name) values("Greiner");
insert into teacher (teacher_name) values("King");
insert into teacher (teacher_name) values("VerLee");

insert into teacher (teacher_name) values("Dudley");
insert into teacher (teacher_name) values("Kalnaraups");

insert into teacher (teacher_name) values("Burroughs");
insert into teacher (teacher_name) values("Compton");

insert into teacher_To_Grade (ttg_teacher_id, ttg_grade_id)
	values (
	(select teacher_id from teacher where teacher_name='Burroughs'),
	(select grade_id  from grade where grade_numb=5));
insert into teacher_To_Grade (ttg_teacher_id, ttg_grade_id)
	values (
	(select teacher_id from teacher where teacher_name='Compton'),
	(select grade_id  from grade where grade_numb=5));

insert into teacher_To_Grade (ttg_teacher_id, ttg_grade_id)
	values (
	(select teacher_id from teacher where teacher_name='Dudley'),
	(select grade_id  from grade where grade_numb=4));
insert into teacher_To_Grade (ttg_teacher_id, ttg_grade_id)
	values (
	(select teacher_id from teacher where teacher_name='Kalnaraups'),
	(select grade_id  from grade where grade_numb=4));

insert into teacher_To_Grade (ttg_teacher_id, ttg_grade_id)
	values (
	(select teacher_id from teacher where teacher_name='Greiner'),
	(select grade_id  from grade where grade_numb=3));
insert into teacher_To_Grade (ttg_teacher_id, ttg_grade_id)
	values (
	(select teacher_id from teacher where teacher_name='King'),
	(select grade_id  from grade where grade_numb=3));
insert into teacher_To_Grade (ttg_teacher_id, ttg_grade_id)
	values (
	(select teacher_id from teacher where teacher_name='VerLee'),
	(select grade_id  from grade where grade_numb=3));

insert into teacher_To_Grade (ttg_teacher_id, ttg_grade_id)
	values (
	(select teacher_id from teacher where teacher_name='Copes'),
	(select grade_id  from grade where grade_numb=2));
insert into teacher_To_Grade (ttg_teacher_id, ttg_grade_id)
	values (
	(select teacher_id from teacher where teacher_name='Cooper'),
	(select grade_id  from grade where grade_numb=2));

insert into teacher_To_Grade (ttg_teacher_id, ttg_grade_id)
	values (
	(select teacher_id from teacher where teacher_name='Taylor'),
	(select grade_id  from grade where grade_numb=2));

insert into events (event_name, description)
	values ("A is for Anatomy", 
	"(All grades) Each team will view models, slides and pictures of organs and tissues from the human body. They will identify and explain the function of each.");
  
insert into events (event_name, description)
	values ("Barge Building", 
	"(2nd grade) Participants construct a barge using aluminum foil that can support a cargo of the largest number of weighted objects (e.g. pennies) without getting them wet.");

insert into events (event_name, description)
	values ("Circuit Wizardry", 
	"(4th and 5th grades) Circuit Wizardry tests participants’ knowledge of basic electrical circuit concepts, components, schematic reading and understanding, and ability to design and build a simple circuit from a functional description.");
insert into events (event_name, description)
	values ("Chopper Challenge", 
	"(4th and 5th grades) Contestants will build and test 3 choppers (rotary flying devises) using only the materials provided at the competition."); 
insert into events (event_name, description)
	values ("Estimania", 
	"(All grades) Measurement is a key component in science. Teams will be asked to either estimate or calculate answers to ten questions of measurement. Types of measurement include area, time, speed, height, length, weight, volume, temperature, and others.");

insert into events (event_name, description)
	values (
	"Map Reading", 
	"(All grades) Students will test their map reading skills to answer geographical questions. They will answer questions using various kinds of maps.");

insert into events (event_name, description)
	values ("Monster Match", 
	"(2nd grade) Waiting for description");
	
insert into events (event_name, description)
	values (
	"Mystery Architecture", 
	"(All grades) Each team will be given a bag of materials (such as paper, tape, Styrofoam, and paper clips) to build a structure that can support a tennis ball. The tallest structure wins.");

insert into events (event_name, description)
	values ("Pentathlon", 
	"(All grades) Five physical skills are combined with science questions in an obstacle course relay race, where each student passes an object to the next student.");
insert into events (event_name, description)
	values (
	"Puff Mobiles", 
	"(2nd and 3rd grade) Each team will build a puff mobile out of beads (for wheels), straw, straight pins, and a piece of paper. Teams will 'puff' their mobile six times. The mobile that is puffed the farthest wins.");

insert into events (event_name, description)
	values ("Rock Hound", 
	"(All grades) Team members will be presented with sample rocks and asked a set of multiple choice questions about each, such as, What type of rock is it? How is it used? How does it react with other compounds?");

insert into events (event_name, description)
	values ("Science Jeopardy", 
		"(4th and 5th grades) Science Jeopardy is played just like Jeopardy on TV. This year all participating teams are asked to contribute two questions.");

insert into events (event_name, description)
	values ("Sink or Float", 
	"(2nd grade) Team predicts what might happen to various objects as they are placed into a bowl of water.");

insert into events (event_name, description)
	values (
	"Straw Tower", 
	"(3rd to 5th grades) Each team attempts to build the strongest straw tower. Each team will construct a tower using no more than 50 drinking straws and 20 straight pins.");

insert into events (event_name, description)
	values (
	"Water Rockets", 
	"(3rd to 5th grades) Students will build a rocket in advance out of a 2-liter soda bottle, making alterations and adding a parachute to help it stay aloft. The rocket that stays in the air the longest will be the winner.");

insert into events (event_name, description)
	values (
	"What Went By",
	"(2nd and 3rd grade) Team will be tested on organisms (animals/birds) which have become extinct or are on the endangered list and the reasons behind these organisms’ extinction or endangered status.");

insert into events (event_name, description)
	values (
	"Write It, Build It", 
	"(3rd to 5th grades) Two team members will be shown a “picture” and will write a description of it. In a separate room, the other team members will be given the pieces of the “picture” and the written description and attempt to rebuild it. The team with the most pieces placed correctly wins. This event tests competitor's ability to clearly communicate in writing and follow written directions.");
	
insert into events (event_name, description)
	values (
	"Potions", 
	"(4th and 5th) Potions");


insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Event and Assistant Coaches",
		"25",
		"Feb-May",
		"Prepare and run practices to prepare the students for Competition Day, set up practice times and locations, aid in communication with students, escort event teams to/from event on Competition Day, be the heart of the success of Lakewood’s Science Olympiad Program.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Lakewood Banner",
		"3",
		"Feb-March before Team Photo",
		"Recruit students from Lakewood Science Olympiad team and help them create a new Lakewood Banner for the Team Photo and the Banner Parade. Photos of banners from other schools are available for ideas generation. Budget available for materials.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Team T-Shirts",
		"2",
		"March",
		"Collect order information, place order, pick up T-shirts, distribute T-shirts to students, and collect money for T-shirts ordered by parents");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Team Photograph and Booklet Page",
		"2",
		"March",
		"Set team photo date, organize students for photo, take team photo, create booklet page using photo (have previous years pages available as examples)");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Event Day Photographer(Morning)",
		"2-3",
		"Competition Day",
		"Take candid shots during Event Day and download photos so they can be used at Celebration Banquet scheduled for the following Monday. Photos include walking to the opening ceremony, banner parade, spectator events, home room, awards ceremony, and any other fun");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Event Day Photographer(Afternoon)",
		"2-3",
		"Competition Day",
		"SEE ABOVE");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Student Name Tags and Best Banner Voting Ballet",
		"2",
		"Completed 1 week before Competition Day",
		"Create, print, and organize student name tags with their name, grade, homeroom number, events, and event times. Deliver to member of Homeroom Set Up Team. Example from last year available. Voting ballet already available – one ballet needs to be with each nametag. Deliver to Homeroom Set Up team 1 week before Competition Day.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Homeroom Set Up",
		"3",
		"Competition Day",
		"Set up homeroom starting at 7:00 am on Event Day; should be done by 7:40 am.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Homeroom Parent",
		"20",
		"Competition Day",
		"Keep everything running smooth in the homeroom during one hour shift on Event Day, check students in/out as they go to events.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Homeroom Clean Up",
		"3",
		"Event Day",
		"Put homeroom back into original condition at end of Event Day and pack up extra handouts, etc.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Homeroom Handouts Creation",
		"2",
		"Completed 1 week before Competition Day",
		"Help the Head Coaching team create information handouts (Events Schedules, School Maps, and other information) that will be available in the homeroom, deliver Masters to Homeroom Handouts Copying team.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Homeroom Student Fun Handouts Creation",
		"2",
		"Completed 1 week before Event Day",
		"Create fun handouts (word finds and other puzzles, preferably with a science theme) for the students to have fun with while waiting in the homeroom, deliver Masters to Homeroom Handouts Copying team.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Homeroom Handouts Copying",
		"2",
		"Completed 2 days before Competition Day",
		"Make copies of the various Homeroom Handouts and deliver to member of the Homeroom Set Up team; Masters of the Homeroom Handouts will be provided 1 week before Event Day.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Student Catcher at Non-Spectator Events Wing Exit",
		"10",
		"Competition Day AM",
		"Stationed at the exit of the Non-Spectator Events wing to keep track of our 2nd & 3rd grade students that exiting and to make sure they are leaving with a parent.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("WESO helper",
		"20",
		"Competition Day",
		"Cover 2 hour shift helping to run an event or direct traffic or other job that WESO needs done to make sure that Science Olympiad is a success; shifts are scheduled by a WESO volunteer the week before event day based on your indicated availability, which you will be asked at a later date.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Celebration Banquet Set Up",
		"5",
		"Monday after Competition Day",
		"Set up the Multi Purpose room for the Celebration Banquet including purchasing paper products, getting drinks in water coolers, moving and arranging tables around, putting dishes on correct tables as families arrive, directing traffic.");

insert into volunteer_Activities (name, num_Of_People, timing, description)
values ("Celebration Banquet Clean Up",
		"5",
		"Monday after Competition Day",
		"Clean up the Multi Purpose room after the Celebration Banquet");
		