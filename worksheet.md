## Adding a Feature 
One of the most important pieces of a buying and selling app, is the ability to make a post. Without this feature, both the sellers and buyers would have no use for the app. The users wouldn’t be able to see any items up for sale,  and the buyers wouldn't be able to put any items up for sale. This [feature](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/issues/3) was implemented first because it was needed in order to have a good starting point.

[User story](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/issues/6)


[Testing](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/blob/669432aa2be92468faa670dc8b8aa0ae151dcff1/app/src/androidTest/java/comp3350/fairprice/objects/PostTest.java)

[Merge commit](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/blob/4e5bee07477b26276b7a0a4d5966f78b90665806/app/src/main/java/comp3350/fairprice/objects/Post.java)



## Exceptional code

The code we have so far does not have any exceptions thrown or caught. This is largely due to our data being hardcoded and the fact that it is early in our development. Down the line exceptions that will be thrown will be mostly related to I/O and database relationships.

## Branching

The branching strategy our group will use for this project will be gitflow branching. In summary, we have a main/master branch which will hold our finalized version of iterations, once they have been fully tested and are error free. A branch called develop will be a copy of the main branch with some additional versions, to identify individual features within the iterations. Furthermore we have a release branch which will be a branch once an iteration is complete with all the features and some documentation and test execution is required for checking the overall working of the whole integrated project upto that iteration. There will be a hotfix branch which is a quick go-to branch after an error is observed in the main/master branch, and will be used for quick bug-fixes. Finally we have multiple feature branches for every individual feature we will assign to each one of our group members to work on separately. 

The whole branching strategy has been explained with details in the README.md file of our project [README.md] under heading “Branching Strategy”.

[graph](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/network/main)
[git log --graph](


## Solid
We searched Group 9’s project for SOLID violations but could not find one. Their project mostly consisted of domain objects that only did what they were supposed to do. There weren’t any repeated code and their code was open to extensions.




## Agile Planning
One of the main things that we pushed to the next iteration was the ability to make a user account and login. We pushed it back because we deemed it to not be the most important part of the project at this point in time. Due to the lack of a database implementation, we also made changes about posting an item.The user will no longer be able to post an image along with the description, price and name of the items for now.

[Feature](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/issues/1)
[User Story](https://code.cs.umanitoba.ca/winter-2022-a01/group-8/fair-price/-/issues/2)
