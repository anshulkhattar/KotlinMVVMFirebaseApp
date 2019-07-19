# KotlinMVVMFirebaseApp

The 3 main tools/languages used in app are as follows:

### Kotlin Language 
It is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is officially supported by Google for mobile development on Android. Since the release of Android Studio 3.0 in October 2017, Kotlin is included as an alternative to the standard Java compiler.
  


### MVVM - Model View viewModel Architecture
MVVM is one of the architectural patterns which enhances separation of concerns, it allows separating the user interface logic from the business (or the back-end) logic. Its target (with other MVC patterns goal) is to achieve the following principle “Keeping UI code simple and free of app logic in order to make it easier to manage”.
**Model**
Model represents the data and business logic of the app. One of the recommended implementation strategies of this layer, is to expose its data through observables to be decoupled completely from ViewModel or any other observer/consumer.
**ViewModel**
ViewModel interacts with model and also prepares observable(s) that can be observed by a View. ViewModel can optionally provide hooks for the view to pass events to the model.One of the important implementation strategies of this layer is to decouple it from the View, i.e, ViewModel should not be aware about the view who is interacting with.
**View**
Finally, the view role in this pattern is to observe (or subscribe to) a ViewModel observable to get data in order to update UI elements accordingly.
     


### Firebase
Firebase is a mobile and web app development platform that provides developers with a plethora of tools and services to help them develop high-quality apps, grow their user base, and earn more profit. The 2 features of Firebase used in the app are:
1. Realtime Database - The Firebase Realtime Database is a cloud-hosted NoSQL database that lets you store and sync between your users in realtime.The Realtime Database is really just one big JSON object that the developers can manage in real time.
2. Auth - Firebase Authentication provides backend services, easy-to-use SDKs, and ready-made UI libraries to authenticate users to the app. Email/Password authentication is used in the app.
          

## Contributing Guidelines
   Feel free to fork and clone the app to run it on your machine. Submit issues with the complete description of the problem.
   
   
   
Star the repository if you find it helpful and visit my profile to checkout my other projects.
          
