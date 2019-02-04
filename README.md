# Currency Converter

Information on the currency of the European Union, the euro (EUR), in relation to the main currencies in the world, updated every thirty minutes.

The service used in this project is provided by Foreign exchange rates and currency conversion. 
For more information: https://fixer.io/documentation

-----
###### Used design pattern

For this project we used the MVVM (Model-View-ViewModel) design pattern, where for each View there is a corresponding ViewModel that communicates with the Model layer, thus isolating the View and Model layers and establishing a clear separation of responsibilities.

![mvvm](app/src/main/res/drawable/pattern_mvvm_scheme.png)

-----
###### Used dependencies

+ LiveData & ViewModel
+ Retrofit
+ Gson
+ Dagger
+ ReactiveX
+ Glide
+ Circle ImageView
