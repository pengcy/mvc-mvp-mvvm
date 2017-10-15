# MVC, MVP and MVVM design pattern examples in Android using Kotlin

## MVC, Model View Controller
**Model**: The classes in the model directory, containing the data and business logics.<br/>
**View**: The xml layout files<br/>
**Controller**: The Activity class, <u>all the logics between the user and the application are happening here</u>.<br/>
In MVC pattern, the model can be easily tested but the controller cannot because it is tightly coupled with Android APIs. As the application gets more complicated, more and more code will be added to the controller which will make it hard to maintain and test. However, it is good for a very simple app which requires very little code.

## MVP pattern, Model View Presenter
**Model**: Same as in MVC pattern<br/>
**View**: The xml layout files and the Activity or Fragment classes<br/>
**Presenter**: The presenter class and interface, <u>all the logics from the controller in MVC pattern are now transferred to the presenter</u><br/>
In MVP pattern, the model can be easily tested as well as the presenter because it is not tied to any Android specific views or APIs. As the application gets complex, the presenter can become huge and hard to maintain.

## MVVM pattern, Model View ViewModel
**Model**: Same as in MVC and MVP pattern<br/>
**View**: The xml layout files and the Activity or Fragment classes, the layout files are bind to the viewmodel 
 through data binding, the data in the layout will be updated through observables.<br/>
**ViewModel**: The viewmodel class and interface, it is similar to presenter in MVP pattern, but instead of talking to the View directly by holding a reference of the view, it is now through <u>data binding and observer pattern</u>.<br/>
In MVVM pattern, unit testing is even easier than MVP because there is no need to mock view anymore. The test only need to verify the observable variables are set appropriately when the model changes. The drawable is that the views can bind both variables and expressions, and it is very easy and tempting to add code the the layout files which will make the layout file hard to maintain and test.


### This is a rewrite of the following repo from Java to Kotlin
https://github.com/ericmaxwell2003/ticTacToe

### References:
https://academy.realm.io/posts/eric-maxwell-mvc-mvp-and-mvvm-on-android/

https://stackoverflow.com/questions/19444431/what-is-difference-between-mvc-mvp-mvvm-design-pattern-in-terms-of-coding-c-s
