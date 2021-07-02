## Simple Exercise to train the basics of stubbing and mocking

Checkout stubSomeValues branch

    git checkout stubSomeValues

Cover the class BirthdayService, by stubbing the Repository to return true or false 
depending on with what name it is called

Then checkout verifySomeBehavior
    
    git checkout verifySomeBehavior
    
Again cover BirthdayService. Since the method greeting has no return value we need to verify that
mailer was called with the correct greeting phrase.

