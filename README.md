# FragmentMVVMExample
An Example of MVVM base on fragment application

The approach:

1.      Create an "MVVM" Class
2.      Create layout and class for each screen - the classes extend from Fragment class (androidx library)
3.      On each fragment on the "onCreateView" method initialize the MVVM class with new ViewModelProvider
4.      Use the instance you have just created to set the new values and set the observers
5.      In the fragment that sends the data: call to the "set" method from the MVVM class
6.      In the fragment that receives the data: set an Observer and attach it to the MVVM class through the observe method
