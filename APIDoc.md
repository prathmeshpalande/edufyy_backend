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
	"questionKey": "/1/1/1"
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
	"questionKey": "/1/1"
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
        "questionKeys": [
            {
                "id": 516,
                "email": "palande1996@gmail.com",
                "questionKey": "/1/1",
                "name": "Question Key 1/1",
                "questionKeys": [
                    {
                        "id": 517,
                        "email": "palande1996@gmail.com",
                        "questionKey": "/1/1/1",
                        "name": "Question Key 1/1/1",
                        "questionKeys": []
                    },
                    {
                        "id": 518,
                        "email": "palande1996@gmail.com",
                        "questionKey": "/1/1/2",
                        "name": "Question Key 1/1/2",
                        "questionKeys": []
                    },
                    {
                        "id": 519,
                        "email": "palande1996@gmail.com",
                        "questionKey": "/1/1/3",
                        "name": "Question Key 1/1/3",
                        "questionKeys": []
                    },
                    {
                        "id": 520,
                        "email": "palande1996@gmail.com",
                        "questionKey": "/1/1/4",
                        "name": "Question Key 1/1/4",
                        "questionKeys": []
                    }
                ]
            }
        ]
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
      "questionKey": "/1/1",
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
    "responseCode": 1,
    "responseMessage": "Success",
    "responseData": {
        "questions": [
            {
                "id": 270,
                "questionKey": "/1/1/3",
                "questionNumber": 4,
                "question": "Question 4",
                "optionA": "Option A",
                "optionB": "Option B",
                "optionC": "Option C",
                "optionD": "Option D",
                "correctOption": "D",
                "developerDifficulty": 1.0,
                "studentDifficulty": 5.0,
                "premium": true
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
	"questionKey":"/1/1/1",
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

* Profile

  URL: http://localhost:8080/profile
  
  Method: POST
  
  Request Body:
  ```json
  {
	"sessionKey": "s"
  }
  ```
  
  Responses:
  	- Failure:
	```json
	{
             "responseCode": -2,
             "responseMessage": "Invalid Session. Please re-login",
             "responseData": null
        }
	```

	- Success:
	```json
	{
             "responseCode": 1,
             "responseMessage": "Success",
             "responseData": {
                 "id": 1,
                 "email": "palande1996@gmail.com",
                 "password": "praimfaya",
                 "name": "Becca Pramheda",
                 "phone": "+999999999999",
                 "source": "Natblida",
                 "premium": true
             }
         }
	```
---

* Reset Password

  URL: http://localhost:8080/reset_password
  
  Method: POST
  
  Request Body:
  ```json
  {
	"email": "palande1996@gmail.com",
	"oldPassword": "praimfaya",
	"newPassword": "sanctum"
  }
  ```
  
  Responses:
  	- Failure:
	```json
	{
             "responseCode": -1,
             "responseMessage": "Incorrect old password, please try again!",
             "responseData": null
        }
	```
	
	```json
	{
             "responseCode": -2,
             "responseMessage": "No such user found!",
             "responseData": null
         }
	```

	- Success:
	```json
	{
             "responseCode": 1,
             "responseMessage": "Success",
             "responseData": null
        }
	```
---
