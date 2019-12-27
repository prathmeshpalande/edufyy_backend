# Edufyy API Documentation


Sample I/Os

* Signup

  URL: http://localhost:8080/signup
  
  Method: POST
  
  Request Body:
  
  ```json
  {
	"name": "Prathmesh Palande",
	"email": "palande1996@gmail.com",
	"phone": "8007440022",
	"source": "becca_pramheda",
	"password": "praimfaya"
  }
  ```
  Responses 
	- Failure:
	```json
	{
		"responseCode":0,
		"responseMessage":"User already exists, please continue to login!",
		"responseData":null
	}
	```
	
	- Success:	
	```json
	{
	    "responseCode":1,
	    "responseMessage":"OTP Sent on Email",
	    "responseData":
	    {
		"sessionKey":"5ca0a242fcbd73c73cbe23c85495203c",
		"otp":"7388"
	    }
	}
	```

---

* Login

  URL: http://localhost:8080/login

  Method: POST

  Request Body:
  ```json
  {
	  "email":"palande1996@gmail.com",
	  "password":"praimfaya"
  }
  ```

  Responses:
	- Failure
	```json
	{
	    "responseCode":-1,
	    "responseMessage":"Invalid Username/Password, please try again!",
	    "responseData":null
	}
	```
	
	- Success
	```json
	{
	    "responseCode":1,
	    "responseMessage":"Success",
	    "responseData":
	    {
		"sessionKey":"0b82b3df73a205c82e3f5acd4a105aa2"
	    }
	}
	```

---

* Proficiency 

  URL: http://localhost:8080/get_proficiency

  Method: POST

  Request Body:
  ```json
  {	
	"sessionKey": "s",
	"questionKey": "1/1/1"
  }
  ```
  
  Responses:
  	- Failure:
	```json
	{
	    "responseCode":-1,
	    "responseMessage":"Invalid session, please login again",
	    "responseData":null
	}
	```

	- Success:
	```json
	{
	    "responseCode":1,
	    "responseMessage":"Success",
	    "responseData":
	    {
		"proficiency":2.8125
	    }
	}
	```

---

* Question keys
  
  URL: http://localhost:8080/get_keys_by_level

  Method: POST
  
  Request Body:
  ```json
  {
	"sessionKey": "s",
	"questionKey": "0"
  }
  ```
  
  Responses:
  	- Failure:
	```json
	  {
		"responseCode":-1,
		"responseMessage":"Invalid session, please login again",
		"responseData":null
	  }
	  ```

	- Success:
	```json
	{
    "responseCode": 1,
    "responseMessage": "Success",
    "responseData": {
        "questionKeys": {
            "4/1/3": {
                "id": 582,
                "email": "palande1996@gmail.com",
                "questionKey": "4/1/3",
                "name": "Question Key 4/1/3"
            },
            "4/3/1": {
                "id": 590,
                "email": "palande1996@gmail.com",
                "questionKey": "4/3/1",
                "name": "Question Key 4/3/1"
            },
            "4/1/4": {
                "id": 583,
                "email": "palande1996@gmail.com",
                "questionKey": "4/1/4",
                "name": "Question Key 4/1/4"
            },
            "4/3/2": {
                "id": 591,
                "email": "palande1996@gmail.com",
                "questionKey": "4/3/2",
                "name": "Question Key 4/3/2"
            },
            "4/1/1": {
                "id": 580,
                "email": "palande1996@gmail.com",
                "questionKey": "4/1/1",
                "name": "Question Key 4/1/1"
            },
            "4/1/2": {
                "id": 581,
                "email": "palande1996@gmail.com",
                "questionKey": "4/1/2",
                "name": "Question Key 4/1/2"
            },
            "4/3/3": {
                "id": 592,
                "email": "palande1996@gmail.com",
                "questionKey": "4/3/3",
                "name": "Question Key 4/3/3"
            },
            "4/3/4": {
                "id": 593,
                "email": "palande1996@gmail.com",
                "questionKey": "4/3/4",
                "name": "Question Key 4/3/4"
            },
            "3/1/1": {
                "id": 559,
                "email": "palande1996@gmail.com",
                "questionKey": "3/1/1",
                "name": "Question Key 3/1/1"
            },
            "2/1": {
                "id": 537,
                "email": "palande1996@gmail.com",
                "questionKey": "2/1",
                "name": "Question Key 2/1"
            },
            "2/2": {
                "id": 542,
                "email": "palande1996@gmail.com",
                "questionKey": "2/2",
                "name": "Question Key 2/2"
            },
            "2/3": {
                "id": 547,
                "email": "palande1996@gmail.com",
                "questionKey": "2/3",
                "name": "Question Key 2/3"
            },
            "4/1": {
                "id": 579,
                "email": "palande1996@gmail.com",
                "questionKey": "4/1",
                "name": "Question Key 4/1"
            },
            "2/4": {
                "id": 552,
                "email": "palande1996@gmail.com",
                "questionKey": "2/4",
                "name": "Question Key 2/4"
            },
            "4/2": {
                "id": 584,
                "email": "palande1996@gmail.com",
                "questionKey": "4/2",
                "name": "Question Key 4/2"
            },
            "3/3/4": {
                "id": 572,
                "email": "palande1996@gmail.com",
                "questionKey": "3/3/4",
                "name": "Question Key 3/3/4"
            },
            "4/3": {
                "id": 589,
                "email": "palande1996@gmail.com",
                "questionKey": "4/3",
                "name": "Question Key 4/3"
            },
            "4/4": {
                "id": 594,
                "email": "palande1996@gmail.com",
                "questionKey": "4/4",
                "name": "Question Key 4/4"
            },
            "3/1/2": {
                "id": 560,
                "email": "palande1996@gmail.com",
                "questionKey": "3/1/2",
                "name": "Question Key 3/1/2"
            },
            "3/1/3": {
                "id": 561,
                "email": "palande1996@gmail.com",
                "questionKey": "3/1/3",
                "name": "Question Key 3/1/3"
            },
            "3/3/1": {
                "id": 569,
                "email": "palande1996@gmail.com",
                "questionKey": "3/3/1",
                "name": "Question Key 3/3/1"
            },
            "3/1/4": {
                "id": 562,
                "email": "palande1996@gmail.com",
                "questionKey": "3/1/4",
                "name": "Question Key 3/1/4"
            },
            "3/3/2": {
                "id": 570,
                "email": "palande1996@gmail.com",
                "questionKey": "3/3/2",
                "name": "Question Key 3/3/2"
            },
            "3/3/3": {
                "id": 571,
                "email": "palande1996@gmail.com",
                "questionKey": "3/3/3",
                "name": "Question Key 3/3/3"
            },
            "2/1/1": {
                "id": 538,
                "email": "palande1996@gmail.com",
                "questionKey": "2/1/1",
                "name": "Question Key 2/1/1"
            },
            "2/1/2": {
                "id": 539,
                "email": "palande1996@gmail.com",
                "questionKey": "2/1/2",
                "name": "Question Key 2/1/2"
            },
            "2/3/3": {
                "id": 550,
                "email": "palande1996@gmail.com",
                "questionKey": "2/3/3",
                "name": "Question Key 2/3/3"
            },
            "2/3/4": {
                "id": 551,
                "email": "palande1996@gmail.com",
                "questionKey": "2/3/4",
                "name": "Question Key 2/3/4"
            },
            "2/1/3": {
                "id": 540,
                "email": "palande1996@gmail.com",
                "questionKey": "2/1/3",
                "name": "Question Key 2/1/3"
            },
            "2/3/1": {
                "id": 548,
                "email": "palande1996@gmail.com",
                "questionKey": "2/3/1",
                "name": "Question Key 2/3/1"
            },
            "2/1/4": {
                "id": 541,
                "email": "palande1996@gmail.com",
                "questionKey": "2/1/4",
                "name": "Question Key 2/1/4"
            },
            "2/3/2": {
                "id": 549,
                "email": "palande1996@gmail.com",
                "questionKey": "2/3/2",
                "name": "Question Key 2/3/2"
            },
            "1/1/4": {
                "id": 520,
                "email": "palande1996@gmail.com",
                "questionKey": "1/1/4",
                "name": "Question Key 1/1/4"
            },
            "1/3/2": {
                "id": 528,
                "email": "palande1996@gmail.com",
                "questionKey": "1/3/2",
                "name": "Question Key 1/3/2"
            },
            "1": {
                "id": 515,
                "email": "palande1996@gmail.com",
                "questionKey": "1",
                "name": "Question Key 1"
            },
            "1/3/3": {
                "id": 529,
                "email": "palande1996@gmail.com",
                "questionKey": "1/3/3",
                "name": "Question Key 1/3/3"
            },
            "1/3/4": {
                "id": 530,
                "email": "palande1996@gmail.com",
                "questionKey": "1/3/4",
                "name": "Question Key 1/3/4"
            },
            "2": {
                "id": 536,
                "email": "palande1996@gmail.com",
                "questionKey": "2",
                "name": "Question Key 2"
            },
            "3": {
                "id": 557,
                "email": "palande1996@gmail.com",
                "questionKey": "3",
                "name": "Question Key 3"
            },
            "4": {
                "id": 578,
                "email": "palande1996@gmail.com",
                "questionKey": "4",
                "name": "Question Key 4"
            },
            "1/1/1": {
                "id": 517,
                "email": "palande1996@gmail.com",
                "questionKey": "1/1/1",
                "name": "Question Key 1/1/1"
            },
            "1/1/2": {
                "id": 518,
                "email": "palande1996@gmail.com",
                "questionKey": "1/1/2",
                "name": "Question Key 1/1/2"
            },
            "1/1/3": {
                "id": 519,
                "email": "palande1996@gmail.com",
                "questionKey": "1/1/3",
                "name": "Question Key 1/1/3"
            },
            "1/3/1": {
                "id": 527,
                "email": "palande1996@gmail.com",
                "questionKey": "1/3/1",
                "name": "Question Key 1/3/1"
            },
            "4/2/2": {
                "id": 586,
                "email": "palande1996@gmail.com",
                "questionKey": "4/2/2",
                "name": "Question Key 4/2/2"
            },
            "4/2/3": {
                "id": 587,
                "email": "palande1996@gmail.com",
                "questionKey": "4/2/3",
                "name": "Question Key 4/2/3"
            },
            "4/4/1": {
                "id": 595,
                "email": "palande1996@gmail.com",
                "questionKey": "4/4/1",
                "name": "Question Key 4/4/1"
            },
            "4/2/1": {
                "id": 585,
                "email": "palande1996@gmail.com",
                "questionKey": "4/2/1",
                "name": "Question Key 4/2/1"
            },
            "4/4/4": {
                "id": 598,
                "email": "palande1996@gmail.com",
                "questionKey": "4/4/4",
                "name": "Question Key 4/4/4"
            },
            "4/2/4": {
                "id": 588,
                "email": "palande1996@gmail.com",
                "questionKey": "4/2/4",
                "name": "Question Key 4/2/4"
            },
            "4/4/2": {
                "id": 596,
                "email": "palande1996@gmail.com",
                "questionKey": "4/4/2",
                "name": "Question Key 4/4/2"
            },
            "4/4/3": {
                "id": 597,
                "email": "palande1996@gmail.com",
                "questionKey": "4/4/3",
                "name": "Question Key 4/4/3"
            },
            "1/1": {
                "id": 516,
                "email": "palande1996@gmail.com",
                "questionKey": "1/1",
                "name": "Question Key 1/1"
            },
            "1/2": {
                "id": 521,
                "email": "palande1996@gmail.com",
                "questionKey": "1/2",
                "name": "Question Key 1/2"
            },
            "1/3": {
                "id": 526,
                "email": "palande1996@gmail.com",
                "questionKey": "1/3",
                "name": "Question Key 1/3"
            },
            "3/1": {
                "id": 558,
                "email": "palande1996@gmail.com",
                "questionKey": "3/1",
                "name": "Question Key 3/1"
            },
            "1/4": {
                "id": 531,
                "email": "palande1996@gmail.com",
                "questionKey": "1/4",
                "name": "Question Key 1/4"
            },
            "3/2": {
                "id": 563,
                "email": "palande1996@gmail.com",
                "questionKey": "3/2",
                "name": "Question Key 3/2"
            },
            "3/3": {
                "id": 568,
                "email": "palande1996@gmail.com",
                "questionKey": "3/3",
                "name": "Question Key 3/3"
            },
            "3/4": {
                "id": 573,
                "email": "palande1996@gmail.com",
                "questionKey": "3/4",
                "name": "Question Key 3/4"
            },
            "3/4/3": {
                "id": 576,
                "email": "palande1996@gmail.com",
                "questionKey": "3/4/3",
                "name": "Question Key 3/4/3"
            },
            "3/4/4": {
                "id": 577,
                "email": "palande1996@gmail.com",
                "questionKey": "3/4/4",
                "name": "Question Key 3/4/4"
            },
            "3/2/1": {
                "id": 564,
                "email": "palande1996@gmail.com",
                "questionKey": "3/2/1",
                "name": "Question Key 3/2/1"
            },
            "3/2/2": {
                "id": 565,
                "email": "palande1996@gmail.com",
                "questionKey": "3/2/2",
                "name": "Question Key 3/2/2"
            },
            "3/2/3": {
                "id": 566,
                "email": "palande1996@gmail.com",
                "questionKey": "3/2/3",
                "name": "Question Key 3/2/3"
            },
            "3/4/1": {
                "id": 574,
                "email": "palande1996@gmail.com",
                "questionKey": "3/4/1",
                "name": "Question Key 3/4/1"
            },
            "3/2/4": {
                "id": 567,
                "email": "palande1996@gmail.com",
                "questionKey": "3/2/4",
                "name": "Question Key 3/2/4"
            },
            "3/4/2": {
                "id": 575,
                "email": "palande1996@gmail.com",
                "questionKey": "3/4/2",
                "name": "Question Key 3/4/2"
            },
            "2/2/1": {
                "id": 543,
                "email": "palande1996@gmail.com",
                "questionKey": "2/2/1",
                "name": "Question Key 2/2/1"
            },
            "2/4/4": {
                "id": 556,
                "email": "palande1996@gmail.com",
                "questionKey": "2/4/4",
                "name": "Question Key 2/4/4"
            },
            "2/2/4": {
                "id": 546,
                "email": "palande1996@gmail.com",
                "questionKey": "2/2/4",
                "name": "Question Key 2/2/4"
            },
            "2/4/2": {
                "id": 554,
                "email": "palande1996@gmail.com",
                "questionKey": "2/4/2",
                "name": "Question Key 2/4/2"
            },
            "2/4/3": {
                "id": 555,
                "email": "palande1996@gmail.com",
                "questionKey": "2/4/3",
                "name": "Question Key 2/4/3"
            },
            "2/2/2": {
                "id": 544,
                "email": "palande1996@gmail.com",
                "questionKey": "2/2/2",
                "name": "Question Key 2/2/2"
            },
            "2/2/3": {
                "id": 545,
                "email": "palande1996@gmail.com",
                "questionKey": "2/2/3",
                "name": "Question Key 2/2/3"
            },
            "2/4/1": {
                "id": 553,
                "email": "palande1996@gmail.com",
                "questionKey": "2/4/1",
                "name": "Question Key 2/4/1"
            },
            "1/2/3": {
                "id": 524,
                "email": "palande1996@gmail.com",
                "questionKey": "1/2/3",
                "name": "Question Key 1/2/3"
            },
            "1/4/1": {
                "id": 532,
                "email": "palande1996@gmail.com",
                "questionKey": "1/4/1",
                "name": "Question Key 1/4/1"
            },
            "1/2/4": {
                "id": 525,
                "email": "palande1996@gmail.com",
                "questionKey": "1/2/4",
                "name": "Question Key 1/2/4"
            },
            "1/4/2": {
                "id": 533,
                "email": "palande1996@gmail.com",
                "questionKey": "1/4/2",
                "name": "Question Key 1/4/2"
            },
            "1/4/3": {
                "id": 534,
                "email": "palande1996@gmail.com",
                "questionKey": "1/4/3",
                "name": "Question Key 1/4/3"
            },
            "1/4/4": {
                "id": 535,
                "email": "palande1996@gmail.com",
                "questionKey": "1/4/4",
                "name": "Question Key 1/4/4"
            },
            "1/2/1": {
                "id": 522,
                "email": "palande1996@gmail.com",
                "questionKey": "1/2/1",
                "name": "Question Key 1/2/1"
            },
            "1/2/2": {
                "id": 523,
                "email": "palande1996@gmail.com",
                "questionKey": "1/2/2",
                "name": "Question Key 1/2/2"
            }
        }
    }
}
	```
---

* Exam

  URL: http://localhost:8080/exam

  Method: POST
  
  Request Body: 	
  ```json
  {
      "sessionKey": "s",
      "questionKey": "1/1",
      "questionCount": 5
  }
  ```
  
  Responses:
  	- Failure:
	```json
	{
	    "responseCode":-1,
	    "responseMessage":"Invalid session, please login again",
	    "responseData":null
	}
	```
	
	- Success:
	```json
	{
	    "responseCode":1,
	    "responseMessage":"Success",
	    "responseData":
	    {
		"questions":
		[
		    {
			"id":259,
			"questionKey":"1/1/1",
			"questionNumber":1,
			"question":"Question 1",
			"optionA":"Option A",
			"optionB":"Option B",
			"optionC":"Option C",
			"optionD":"Option D",
			"correctOption":"B",
			"developerDifficulty":2.0,
			"studentDifficulty":5.0,
			"premium":true
		    },
		    {
			"id":265,
			"questionKey":"1/1/2",
			"questionNumber":3,
			"question":"Question 3",
			"optionA":"Option A",
			"optionB":"Option B",
			"optionC":"Option C",
			"optionD":"Option D",
			"correctOption":"C",
			"developerDifficulty":2.0,
			"studentDifficulty":1.0,
			"premium":true
		    },
		    {
			"id":270,
			"questionKey":"1/1/3",
			"questionNumber":4,
			"question":"Question 4",
			"optionA":"Option A",
			"optionB":"Option B",
			"optionC":"Option C",
			"optionD":"Option D",
			"correctOption":"C",
			"developerDifficulty":2.0,
			"studentDifficulty":2.0,
			"premium":true
		    },
		    {
			"id":271,
			"questionKey":"1/1/4",
			"questionNumber":1,
			"question":"Question 1",
			"optionA":"Option A",
			"optionB":"Option B",
			"optionC":"Option C",
			"optionD":"Option D",
			"correctOption":"D",
			"developerDifficulty":1.0,
			"studentDifficulty":5.0,
			"premium":true
		    },
		    {
			"id":274,
			"questionKey":"1/1/4",
			"questionNumber":4,
			"question":"Question 4",
			"optionA":"Option A",
			"optionB":"Option B",
			"optionC":"Option C",
			"optionD":"Option D",
			"correctOption":"A",
			"developerDifficulty":1.0,
			"studentDifficulty":4.0,
			"premium":true
		    }
		]
	    }
	}
	```

---

* Submit Answer

  URL: http://localhost:8080/submit_answer
  
  Method: POST
  
  Request Body:
  ```json
  {
	"sessionKey":"s",
	"questionKey":"1/1/1",
	"questionNumber":1,
	"studentDifficulty":3,
	"surety":3,
	"answer":"C"
  }
  ```
  
  Responses:
  	- Failure:
	```json
	{
	    "responseCode":-1,
	    "responseMessage":"Invalid session, please login again",
	    "responseData":null
	}
	```

	- Success:
	```json
	{
	    "responseCode":1,
	    "responseMessage":"Success",
	    "responseData":null
	}
	```
---
