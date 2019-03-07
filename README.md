# JavaCodeFormatter
Code Formatter, Indent, Parenthesis checker, Code formatting.  

## Prerequisites
Android SDK v28
Latest Android Build Tools
Android Support Repository

## Features

Simple login screen.
- Fake API call for delay
- View interaction with presenter
- Presenter interaction with View/Model

## Description

- MainActivity implements MainActivityPresenter.View and overrides these methods.

        public interface View {
          void updateLoginResponse(String response);
          void clearInputFeilds();
          void showProgressBar();
          void hideProgressBar();
        }
                
- You can add any dummy credentials on login screen to proceed View communicates to presenter.

        private MainActivityPresenter presenter = new MainActivityPresenter(this);
        presenter.loginAPICall("email", "password");  
   after calling this there would be a dummy loader for fake API call (see MainActivityPresenter class) and return response to View. 
   
       mainActivityView.updateLoginResponse("Successfully logged in with these credentials: \n\n" + user.toString());
       mainActivityView.clearInputFeilds();
       mainActivityView.hideProgressBar();


### Images
<img src="./screens/1.png" width="200"/> <img src="./screens/2.png" width="200"/>
 <img src="./screens/3.png" width="200"/> <img src="./screens/4.png" width="200"/>
 <img src="./screens/5.png" width="200"/>
<br/>


## Author
[Waheed Nazir](https://www.linkedin.com/in/waheed-nazir-36521579/ "Waheed Nazir (WaveTechStudio)")

## License
It is totally free to use. :)

