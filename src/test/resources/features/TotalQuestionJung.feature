@Quiz-Total-Questions
  Feature: Quiz Total Questions
    Background:
      Given I go to the "login" page
      When I type the "ask_instr@aol.com" into email field
      And I enter the "12345" as  password
      When I click the button "Sign In"
      And I wait for 1 sec[s]
      When I click on the "Quizzes" menu item
      And I wait for 1 sec[s]

    @Quiz1
    Scenario: Create a quiz with one question
      And I click the button "Create New Quiz"
      And I wait for 1 sec[s]
      When I type the "Test Quiz - Jung" as quiz title
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q1" question and "Textual" question type
      When I type the "What is Software Testing?" into "Q1"
      And I wait for 2 sec[s]
      And I click button "Save"
      And I wait for 1 sec[s]
      Then I check the quiz "Test Quiz - Jung" displayed on the list of quizzes
      And I wait for 1 sec[s]
      And I delete the "Test Quiz - Jung"

    @Quiz2
    Scenario: Create a quiz without any question
      And I click the button "Create New Quiz"
      And I wait for 1 sec[s]
      When I type the "Test Quiz - Jung" as quiz title
      And I add the question
      And I wait for 5 sec[s]
      And I click button "Save"
      And I can see the "Quiz is not completed" message
      And I wait for 1 sec[s]

    @Quiz3
    Scenario: Create a quiz with a total maximum numbers of question - 50 per quiz
      And I click the button "Create New Quiz"
      And I wait for 1 sec[s]
      When I type the "Test Quiz - Jung" as quiz title
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q1" question and "Textual" question type
      When I type the "Who is your hero?" into "Q1"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q2" question and "Single" question type
      When I type the "If you could live anywhere, where would it be?" into "Q2"
      And I wait for 2 sec[s]
      And I type the "Glasses" as "Option 1*" into "Q2"
      And I type the "Watch" as "Option 2*" into "Q2"
      And I click the "Q2" Option add button
      And I type the "Toilet" as "Option 3*" into "Q2"
      And I click the "Q2" Option add button
      And I type the "Peaceful and no painful happy world" as "Option 4*" into "Q2"
      And I select the "Option 4*" as correct option in "Q2"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q3" question and "Multiple" question type
      When I type the "What is your biggest fear?" into "Q3"
      And I wait for 2 sec[s]
      And I type the "War" as "Option 1*" into "Q3"
      And I type the "Death" as "Option 2*" into "Q3"
      And I click the "Q3" Option add button
      And I type the "Happy" as "Option 3*" into "Q3"
      And I click the "Q3" Option add button
      And I type the "Natural Disaster" as "Option 4*" into "Q3"
      And I select the "Option 1*" as correct multiple option in "Q3"
      And I select the "Option 2*" as correct multiple option in "Q3"
      And I select the "Option 4*" as correct multiple option in "Q3"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q4" question and "Textual" question type
      When I type the "What is your favorite family vacation?" into "Q4"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q5" question and "Single" question type
      When I type the "What would you change about yourself if you could?" into "Q5"
      And I wait for 2 sec[s]
      And I type the "Glasses" as "Option 1*" into "Q5"
      And I type the "Watch" as "Option 2*" into "Q5"
      And I click the "Q5" Option add button
      And I type the "Toilet" as "Option 3*" into "Q5"
      And I click the "Q5" Option add button
      And I type the "Shape of body" as "Option 4*" into "Q5"
      And I select the "Option 4*" as correct option in "Q5"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q6" question and "Multiple" question type
      When I type the "What really makes you angry?" into "Q6"
      And I wait for 2 sec[s]
      And I type the "War" as "Option 1*" into "Q6"
      And I type the "Death" as "Option 2*" into "Q6"
      And I click the "Q6" Option add button
      And I type the "Happy" as "Option 3*" into "Q6"
      And I click the "Q6" Option add button
      And I type the "Natural Disaster" as "Option 4*" into "Q6"
      And I select the "Option 1*" as correct multiple option in "Q6"
      And I select the "Option 2*" as correct multiple option in "Q6"
      And I select the "Option 4*" as correct multiple option in "Q6"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q7" question and "Textual" question type
      When I type the "What motivates you to work hard?" into "Q7"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q8" question and "Textual" question type
      When I type the "What is your favorite thing about your career?" into "Q8"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q9" question and "Textual" question type
      When I type the "What is your biggest complaint about your job?" into "Q9"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q10" question and "Textual" question type
      When I type the "What is your proudest accomplishment?" into "Q10"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q11" question and "Textual" question type
      When I type the "What is your child's proudest accomplishment?" into "Q11"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q12" question and "Textual" question type
      When I type the "What is your favorite book to read?" into "Q12"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q13" question and "Textual" question type
      When I type the "What makes you laugh the most?" into "Q13"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q14" question and "Textual" question type
      When I type the "What was the last movie you went to? What did you think?" into "Q14"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q15" question and "Textual" question type
      When I type the "What did you want to be when you were small?" into "Q15"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q16" question and "Textual" question type
      When I type the "What does your child want to be when he/she grows up?" into "Q16"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q17" question and "Textual" question type
      When I type the "If you could choose to do anything for a day, what would it be?" into "Q17"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q18" question and "Textual" question type
      When I type the "What is your favorite game or sport to watch and play?" into "Q18"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q19" question and "Textual" question type
      When I type the "Would you rather ride a bike, ride a horse, or drive a car?" into "Q19"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q20" question and "Textual" question type
      When I type the "What would you sing at Karaoke night?" into "Q20"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q21" question and "Textual" question type
      When I type the "What two radio stations do you listen to in the car the most?" into "Q21"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q22" question and "Textual" question type
      When I type the "Which would you rather do: wash dishes, mow the lawn, clean the bathroom, or vacuum the house?" into "Q22"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q23" question and "Textual" question type
      When I type the "If you could hire someone to help you, would it be with cleaning, cooking, or yard work?" into "Q23"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q24" question and "Textual" question type
      When I type the "If you could only eat one meal for the rest of your life, what would it be?" into "Q24"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q25" question and "Textual" question type
      When I type the "Who is your favorite author?" into "Q25"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q26" question and "Textual" question type
      When I type the "Have you ever had a nickname? What is it?" into "Q26"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q27" question and "Textual" question type
      When I type the "Do you like or dislike surprises? Why or why not?" into "Q27"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q28" question and "Textual" question type
      When I type the "In the evening, would you rather play a game, visit a relative, watch a movie, or read?" into "Q28"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q29" question and "Textual" question type
      When I type the "Would you rather vacation in Hawaii or Alaska, and why?" into "Q29"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q30" question and "Textual" question type
      When I type the "Would you rather win the lottery or work at the perfect job? And why?" into "Q30"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q31" question and "Textual" question type
      When I type the "Who would you want to be stranded with on a deserted island?" into "Q31"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q32" question and "Textual" question type
      When I type the "If money was no object, what would you do all day?" into "Q32"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q33" question and "Textual" question type
      When I type the " If you could go back in time, what year would you travel to?" into "Q33"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q34" question and "Textual" question type
      When I type the " How would your friends describe you?" into "Q34"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q35" question and "Textual" question type
      When I type the "What are your hobbies?" into "Q35"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q36" question and "Textual" question type
      When I type the "What is the best gift you have been given?" into "Q36"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q37" question and "Textual" question type
      When I type the " What is the worst gift you have received?" into "Q37"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q38" question and "Textual" question type
      When I type the "Aside from necessities, what one thing could you not go a day without?" into "Q38"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q39" question and "Textual" question type
      When I type the "List two pet peeves." into "Q39"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q40" question and "Textual" question type
      When I type the "Where do you see yourself in five years?" into "Q40"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q41" question and "Textual" question type
      When I type the "How many pairs of shoes do you own?" into "Q41"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q42" question and "Textual" question type
      When I type the "If you were a super-hero, what powers would you have?" into "Q42"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q43" question and "Textual" question type
      When I type the "What would you do if you won the lottery?" into "Q43"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q44" question and "Textual" question type
      When I type the "What form of public transportation do you prefer? (air, boat, train, bus, car, etc.)" into "Q44"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q45" question and "Textual" question type
      When I type the "What's your favorite zoo animal?" into "Q45"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q46" question and "Textual" question type
      When I type the "If you could go back in time to change one thing, what would it be?" into "Q46"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q47" question and "Textual" question type
      When I type the "If you could share a meal with any 4 individuals, living or dead, who would they be?" into "Q47"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q48" question and "Textual" question type
      When I type the "How many pillows do you sleep with?" into "Q48"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q49" question and "Textual" question type
      When I type the "What's the longest you've gone without sleep (and why)?" into "Q49"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q50" question and "Textual" question type
      When I type the "What's the tallest building you've been to the top in?" into "Q50"
      And I wait for 5 sec[s]
      And I click button "Save"
      And I wait for 5 sec[s]
      Then I check the quiz "Test Quiz - Jung" displayed on the list of quizzes
      And I wait for 1 sec[s]
      And I delete the "Test Quiz - Jung"

    @Quiz4
    Scenario: Create a quiz with a 51 questions
      And I click the button "Create New Quiz"
      And I wait for 1 sec[s]
      When I type the "Test Quiz - Jung" as quiz title
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q1" question and "Textual" question type
      When I type the "Who is your hero?" into "Q1"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q2" question and "Single" question type
      When I type the "If you could live anywhere, where would it be?" into "Q2"
      And I wait for 2 sec[s]
      And I type the "Glasses" as "Option 1*" into "Q2"
      And I type the "Watch" as "Option 2*" into "Q2"
      And I click the "Q2" Option add button
      And I type the "Toilet" as "Option 3*" into "Q2"
      And I click the "Q2" Option add button
      And I type the "Peaceful and no painful happy world" as "Option 4*" into "Q2"
      And I select the "Option 4*" as correct option in "Q2"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q3" question and "Multiple" question type
      When I type the "What is your biggest fear?" into "Q3"
      And I wait for 2 sec[s]
      And I type the "War" as "Option 1*" into "Q3"
      And I type the "Death" as "Option 2*" into "Q3"
      And I click the "Q3" Option add button
      And I type the "Happy" as "Option 3*" into "Q3"
      And I click the "Q3" Option add button
      And I type the "Natural Disaster" as "Option 4*" into "Q3"
      And I select the "Option 1*" as correct multiple option in "Q3"
      And I select the "Option 2*" as correct multiple option in "Q3"
      And I select the "Option 4*" as correct multiple option in "Q3"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q4" question and "Textual" question type
      When I type the "What is your favorite family vacation?" into "Q4"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q5" question and "Single" question type
      When I type the "What would you change about yourself if you could?" into "Q5"
      And I wait for 2 sec[s]
      And I type the "Glasses" as "Option 1*" into "Q5"
      And I type the "Watch" as "Option 2*" into "Q5"
      And I click the "Q5" Option add button
      And I type the "Toilet" as "Option 3*" into "Q5"
      And I click the "Q5" Option add button
      And I type the "Shape of body" as "Option 4*" into "Q5"
      And I select the "Option 4*" as correct option in "Q5"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q6" question and "Multiple" question type
      When I type the "What really makes you angry?" into "Q6"
      And I wait for 2 sec[s]
      And I type the "War" as "Option 1*" into "Q6"
      And I type the "Death" as "Option 2*" into "Q6"
      And I click the "Q6" Option add button
      And I type the "Happy" as "Option 3*" into "Q6"
      And I click the "Q6" Option add button
      And I type the "Natural Disaster" as "Option 4*" into "Q6"
      And I select the "Option 1*" as correct multiple option in "Q6"
      And I select the "Option 2*" as correct multiple option in "Q6"
      And I select the "Option 4*" as correct multiple option in "Q6"
      And I wait for 2 sec[s]
      And I add the question
      And I wait for 5 sec[s]
      When I select the "Q7" question and "Textual" question type
      When I type the "What motivates you to work hard?" into "Q7"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q8" question and "Textual" question type
      When I type the "What is your favorite thing about your career?" into "Q8"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q9" question and "Textual" question type
      When I type the "What is your biggest complaint about your job?" into "Q9"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q10" question and "Textual" question type
      When I type the "What is your proudest accomplishment?" into "Q10"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q11" question and "Textual" question type
      When I type the "What is your child's proudest accomplishment?" into "Q11"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q12" question and "Textual" question type
      When I type the "What is your favorite book to read?" into "Q12"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q13" question and "Textual" question type
      When I type the "What makes you laugh the most?" into "Q13"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q14" question and "Textual" question type
      When I type the "What was the last movie you went to? What did you think?" into "Q14"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q15" question and "Textual" question type
      When I type the "What did you want to be when you were small?" into "Q15"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q16" question and "Textual" question type
      When I type the "What does your child want to be when he/she grows up?" into "Q16"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q17" question and "Textual" question type
      When I type the "If you could choose to do anything for a day, what would it be?" into "Q17"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q18" question and "Textual" question type
      When I type the "What is your favorite game or sport to watch and play?" into "Q18"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q19" question and "Textual" question type
      When I type the "Would you rather ride a bike, ride a horse, or drive a car?" into "Q19"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q20" question and "Textual" question type
      When I type the "What would you sing at Karaoke night?" into "Q20"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q21" question and "Textual" question type
      When I type the "What two radio stations do you listen to in the car the most?" into "Q21"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q22" question and "Textual" question type
      When I type the "Which would you rather do: wash dishes, mow the lawn, clean the bathroom, or vacuum the house?" into "Q22"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q23" question and "Textual" question type
      When I type the "If you could hire someone to help you, would it be with cleaning, cooking, or yard work?" into "Q23"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q24" question and "Textual" question type
      When I type the "If you could only eat one meal for the rest of your life, what would it be?" into "Q24"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q25" question and "Textual" question type
      When I type the "Who is your favorite author?" into "Q25"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q26" question and "Textual" question type
      When I type the "Have you ever had a nickname? What is it?" into "Q26"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q27" question and "Textual" question type
      When I type the "Do you like or dislike surprises? Why or why not?" into "Q27"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q28" question and "Textual" question type
      When I type the "In the evening, would you rather play a game, visit a relative, watch a movie, or read?" into "Q28"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q29" question and "Textual" question type
      When I type the "Would you rather vacation in Hawaii or Alaska, and why?" into "Q29"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q30" question and "Textual" question type
      When I type the "Would you rather win the lottery or work at the perfect job? And why?" into "Q30"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q31" question and "Textual" question type
      When I type the "Who would you want to be stranded with on a deserted island?" into "Q31"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q32" question and "Textual" question type
      When I type the "If money was no object, what would you do all day?" into "Q32"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q33" question and "Textual" question type
      When I type the " If you could go back in time, what year would you travel to?" into "Q33"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q34" question and "Textual" question type
      When I type the " How would your friends describe you?" into "Q34"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q35" question and "Textual" question type
      When I type the "What are your hobbies?" into "Q35"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q36" question and "Textual" question type
      When I type the "What is the best gift you have been given?" into "Q36"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q37" question and "Textual" question type
      When I type the " What is the worst gift you have received?" into "Q37"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q38" question and "Textual" question type
      When I type the "Aside from necessities, what one thing could you not go a day without?" into "Q38"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q39" question and "Textual" question type
      When I type the "List two pet peeves." into "Q39"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q40" question and "Textual" question type
      When I type the "Where do you see yourself in five years?" into "Q40"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q41" question and "Textual" question type
      When I type the "How many pairs of shoes do you own?" into "Q41"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q42" question and "Textual" question type
      When I type the "If you were a super-hero, what powers would you have?" into "Q42"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q43" question and "Textual" question type
      When I type the "What would you do if you won the lottery?" into "Q43"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q44" question and "Textual" question type
      When I type the "What form of public transportation do you prefer? (air, boat, train, bus, car, etc.)" into "Q44"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q45" question and "Textual" question type
      When I type the "What's your favorite zoo animal?" into "Q45"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q46" question and "Textual" question type
      When I type the "If you could go back in time to change one thing, what would it be?" into "Q46"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q47" question and "Textual" question type
      When I type the "If you could share a meal with any 4 individuals, living or dead, who would they be?" into "Q47"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q48" question and "Textual" question type
      When I type the "How many pillows do you sleep with?" into "Q48"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q49" question and "Textual" question type
      When I type the "What's the longest you've gone without sleep (and why)?" into "Q49"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q50" question and "Textual" question type
      When I type the "What's the tallest building you've been to the top in?" into "Q50"
      And I wait for 1 sec[s]
      And I add the question
      And I wait for 1 sec[s]
      When I select the "Q51" question and "Textual" question type
      When I type the "Would you rather trade intelligence for looks or looks for intelligence?" into "Q51"
      And I wait for 5 sec[s]
      And I click button "Save"
      And I wait for 5 sec[s]
#      And I can see the over 50 quiz message "No more than 50 questions allowed"
#      And I wait for 5 sec[s]
