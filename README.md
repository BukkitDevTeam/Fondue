Fondue
======

An up and coming Minecraft server API implementation.

Helping Out
-----------

Help is always appreciated, and we will endeavour to look at your issues / pull requests as quickly as possible.
If you wish to help out, welcome! Familiarize yourself with the code and then contact md_5 on irc.esper.net to request repo access.
The best place to contact us is #fondue on irc.esper.net

Compilation
-----------

We use maven to handle our dependencies.

* Install [Maven 3](http://maven.apache.org/download.html)
* Check out this repo and: `mvn clean install`

Coding and Pull Request Conventions
-----------

* We generally follow the Sun/Oracle coding standards.
* No tabs; use 4 spaces instead.
* No trailing whitespaces.
* No CRLF line endings, LF only, put your gits 'core.autocrlf' on 'true'.
* No 80 column limit or 'weird' midstatement newlines.
* The number of commits in a pull request should be kept to a minimum (squish them into one most of the time - use common sense!).
* No merges should be included in pull requests unless the pull request's purpose is a merge.
* Pull requests should be tested (does it compile? AND does it work?) before submission.
* Any major additions should have documentation ready and provided if applicable (this is usually the case).
* Try to follow test driven development where applicable.

Tips to get your pull request accepted
-----------
Making sure you follow the above conventions is important, but just the beginning. Follow these tips to better the chances of your pull request being accepted and pulled.

* Make sure you follow all of our conventions to the letter.
* Make sure your code compiles under Java 6.
* Provide proper JavaDocs where appropriate.
* Provide proper accompanying documentation where appropriate.
* Test your code.
* Make sure to follow coding best practises.
* Your pull request should link to accompanying pull requests.
* The description of your pull request should provide detailed information on the pull along with justification of the changes where applicable.
