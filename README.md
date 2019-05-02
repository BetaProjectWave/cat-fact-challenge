
# Interview Challenge - Cat Facts API

We would like you to write an application that provides a RESTful API onto third party data.

We have provided a core skeleton for a Java Spring Boot application. You are asked to use an external API that provides facts about cats. Documentation on the API can be found at: https://catfact.ninja/ and the main APIs that you will use will be one or both of https://catfact.ninja/facts and https://catfact.ninja/breeds

An initial endpoint has been defined at `/facts` which will return a listing of all cat facts available in the target API service using a `FactDTO`.

We would like you to add to this application with the following requirements:

**Basic Requirements**

* Expose suitably designed and implemented endpoints to retrieve the data from the `Cat Facts API Service`
* Return `fact`s filtered by a provided `keyword` parameter, for example `Egypt`
* Return all breeds available from the source API as a list of `breed`s
* Show a data summary response showing the count of all breeds of cats grouped by their `coat` properties

**Stretch Goals**

* Return `breed`s filtered by either a provided `coat` parameter AND/OR a provided `country` parameter
* Allow a specific `breed` record to be retrieved by a path parameter of the `breed` name
* Implement `pagination` behaviour that can be applied to one or both of the `fact` and `breed` endpoints

You are free to add additional functionality in addition to the above if you so wish.

You may tackle the problem in any suitable development environment. If you so wish, you can tackle the problem using a different language or framework. 

This challenge is intended to be completed by candidates of all levels and experience, so you should attempt to complete as much as you feel demonstrates your capability. There is no expectation that all candidates will be able to complete all parts of this challenge. There is no time limit, but time taken may be taken into consideration during assessment.
