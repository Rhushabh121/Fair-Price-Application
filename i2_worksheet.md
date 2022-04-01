## Paying off technical debt

1. Initially our database only allowed a user to add one post. It overrode the user's previous post every time a new post was added . Obviously this was not ideal, but it was good enough for us to be able to use it and create other features around the database. We paid off this debt by ensuring you can now add more than one post at a time without any hinderance.
This debt is classified as Deliberate and Prudent. We knew that aspect of our code wasn’t working but we decided to not fix it as it wasn't a big problem at the time. It was prudent because we decided to deal with the consequence of getting a lower mark for that aspect.
[Instance 1](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/commit/e2525216a219a9fb3f8ad2d885aa61ef368fb113?page=2#acff40041f9beac0cacb1ea5fa3b0c3279fc253b_34_73) 

2. Second instance is where we were not able to figure out how to create an individual instance of the whole application tailored to the user’s profile privately. We overcame that by simply laying out the structure to the whole application first and ensuring all the pages connect to different pages for users to be able to navigate and have that first prototype of the project in place. We pushed the profile integration to the private instance of application to the next iteration. 
This debt is classified as Inadvertent and Prudent. We decided to lay out the foundations for the app for the release rather than implementing the whole thing altogether rather than having only 1-2 view layout pages in the app.

[Instance 2a]
(https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/commits/feature_Login/)
[Instance 2b]
(https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/commits/feature_Login/)

## SOLID VIOLATION
We searched Group 7's project for SOLID violations but could not find a reasonable one. Each of their classes were short and only did one thing. There weren't any repeated files and their code was open to extensions.

## Retrospective
The Retrospective has helped us all in how we assign issues to each member of the group. It made us more organized, leading to us being more effective when it comes to meeting deadlines, and it proved to ourselves our ability to have fairly distributed tasks. We were able to add more features than we did in the second iteration compared to the first. Our evidence is the progress from our interation1 project to our iteration 2 project. Iteration was more of a backbone compared to iteration 2 which is more functional.

## Design patterns
[Creational](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/blob/main/app/src/main/java/comp3350/fairprice/presentation/NewPostActivity.java): Posts publishing depends upon user account existence

[Structural](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/blob/main/app/src/main/java/comp3350/fairprice/presentation/ListAdapter.java): Adapter 

[Behavioral](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/blob/main/app/src/main/java/comp3350/fairprice/presentation/Register.java): Account creation depends upon database 




## Iteration 1 Feedback fixes

[Issue](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/issues/20)

In our first iteration of the project, we didn’t have the correct architecture for our app. We didn’t have a proper persistence class where our stub database should have been held. This was pointed out in this issue. We fixed this problem by simply moving our database to a separate layer so it no longer shared a layer with the logic classes.

## ITERATION 3 DEFERRED FEATURES

Categories - Each category does not currently split up the items into the right one. They are all filtered to the same space as of now

Login/Register - The Backend of those are not complete as of now as we need to make a private session for the user who has logged in to the app.
