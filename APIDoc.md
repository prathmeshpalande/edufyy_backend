Edufyy API Documentation


Sample I/Os

1.URL: http://localhost:8080/signup
2.Method: POST
3.I/P: 	{
		"name": "Prathmesh Palande",
	"email": "palande1996@gmail.com",
	"phone": "8007440022",
	"source": "becca_pramheda",
	"password": "praimfaya"
}
4.O/P: Failure:
{
    "responseCode": 0,
    "responseMessage": "User already exists, please continue to login!",
    "responseData": null
}
a)Success:
{
    "responseCode": 1,
    "responseMessage": "OTP Sent on Email",
    "responseData": {
        "sessionKey": "5ca0a242fcbd73c73cbe23c85495203c",
        "otp": "7388"
    }
}

5.URL: http://localhost:8080/login
6.Method: POST
7.I/P: 	
{
	"email": "palande1996@gmail.com",
	"password": "praimfaya"
}
8.O/P: Failure:
{
    "responseCode": -1,
    "responseMessage": "Invalid Username/Password, please try again!",
    "responseData": null
}
a)Success:
{
    "responseCode": 1,
    "responseMessage": "Success",
    "responseData": {
        "sessionKey": "0b82b3df73a205c82e3f5acd4a105aa2"
    }
}

9.URL: http://localhost:8080/get_proficiency
10.Method: POST
11.I/P: 	
{
	"sessionKey": "s",
	"questionKey": "1/1/1"
}
12.O/P: Failure:
{
    "responseCode": -1,
    "responseMessage": "Invalid session, please login again",
    "responseData": null
}

a)Success:
{
    "responseCode": 1,
    "responseMessage": "Success",
    "responseData": {
        "proficiency": 2.8125
    }
}

13.URL: http://localhost:8080/get_keys_by_level
14.Method: POST
15.I/P: 	
{
	"sessionKey": "s",
	"questionKey": "1/1"
}
16.O/P: Failure:
{
    "responseCode": -1,
    "responseMessage": "Invalid session, please login again",
    "responseData": null
}

a)Success:
{
    "responseCode": 1,
    "responseMessage": "Success",
    "responseData": {
        "questionKeys": [
            {
                "id": 516,
                "email": "palande1996@gmail.com",
                "questionKey": "1/1",
                "name": "Question Key 1/1"
            },
            {
                "id": 517,
                "email": "palande1996@gmail.com",
                "questionKey": "1/1/1",
                "name": "Question Key 1/1/1"
            },
            {
                "id": 518,
                "email": "palande1996@gmail.com",
                "questionKey": "1/1/2",
                "name": "Question Key 1/1/2"
            },
            {
                "id": 519,
                "email": "palande1996@gmail.com",
                "questionKey": "1/1/3",
                "name": "Question Key 1/1/3"
            },
            {
                "id": 520,
                "email": "palande1996@gmail.com",
                "questionKey": "1/1/4",
                "name": "Question Key 1/1/4"
            }
        ]
    }
}

17.URL: http://localhost:8080/exam
18.Method: POST
19.I/P: 	
{
	"sessionKey": "s",
	"questionKey": "1/1"
}
20.O/P: Failure:
{
    "responseCode": -1,
    "responseMessage": "Invalid session, please login again",
    "responseData": null
}

a)Success:
{
    "responseCode": 1,
    "responseMessage": "Success",
    "responseData": {
        "questions": [
            {
                "id": 259,
                "questionKey": "1/1/1",
                "questionNumber": 1,
                "question": "Question 1",
                "optionA": "Option A",
                "optionB": "Option B",
                "optionC": "Option C",
                "optionD": "Option D",
                "correctOption": "B",
                "developerDifficulty": 2.0,
                "studentDifficulty": 5.0,
                "premium": true
            },
            {
                "id": 265,
                "questionKey": "1/1/2",
                "questionNumber": 3,
                "question": "Question 3",
                "optionA": "Option A",
                "optionB": "Option B",
                "optionC": "Option C",
                "optionD": "Option D",
                "correctOption": "C",
                "developerDifficulty": 2.0,
                "studentDifficulty": 1.0,
                "premium": true
            },
            {
                "id": 270,
                "questionKey": "1/1/3",
                "questionNumber": 4,
                "question": "Question 4",
                "optionA": "Option A",
                "optionB": "Option B",
                "optionC": "Option C",
                "optionD": "Option D",
                "correctOption": "C",
                "developerDifficulty": 2.0,
                "studentDifficulty": 2.0,
                "premium": true
            },
            {
                "id": 271,
                "questionKey": "1/1/4",
                "questionNumber": 1,
                "question": "Question 1",
                "optionA": "Option A",
                "optionB": "Option B",
                "optionC": "Option C",
                "optionD": "Option D",
                "correctOption": "D",
                "developerDifficulty": 1.0,
                "studentDifficulty": 5.0,
                "premium": true
            },
            {
                "id": 274,
                "questionKey": "1/1/4",
                "questionNumber": 4,
                "question": "Question 4",
                "optionA": "Option A",
                "optionB": "Option B",
                "optionC": "Option C",
                "optionD": "Option D",
                "correctOption": "A",
                "developerDifficulty": 1.0,
                "studentDifficulty": 4.0,
                "premium": true
            }
        ]
    }
}

21.URL: http://localhost:8080/submit_answer
22.Method: POST
23.I/P: 	
{
	"sessionKey": "s",
	"questionKey": "1/1/1",
	"questionNumber": 1,
	"studentDifficulty": 3,
	"surety": 3,
	"answer": "C"
}
24.O/P: Failure:
{
    "responseCode": -1,
    "responseMessage": "Invalid session, please login again",
    "responseData": null
}

a)Success:
{
    "responseCode": 1,
    "responseMessage": "Success",
    "responseData": null
}
