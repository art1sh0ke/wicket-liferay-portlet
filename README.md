## Achievement Portlet

This is an example portlet developed for series of my blog posts "Creating portlet for Liferay Portal with Wicket" (in Russian):

* [Part 1. Portlet project for Liferay Portal](http://www.shafranov.net/blog/2012/06/08/liferay-wicket-1-liferay/)
* [Part 2. Configuration of Wicket portlet, or web.xml, portlet.xml, etc](http://www.shafranov.net/blog/2012/06/08/liferay-wicket-2-wicket-webxml/)
* [Part 3. Development of the portlet's functionality](http://www.shafranov.net/blog/2012/08/18/sozdaniie-portlieta-dlia-liferay-s-pomoshchiu-wicket-chast-3-razrabotka-funktsionalnosti-portlieta/)
* [Part 4. If Spring Framework is used](http://shafranov.net/blog/2012/10/21/sozdaniie-portlieta-dlia-liferay-s-pomoshchiu-wicket-chast-4-iesli-ispolzuietsia-spring-framework/)

Example demonstrates how to use Apache Wicket framework to develop AJAX-enabled portlet for Liferay Portal. 

In the VIEW mode portlet shows a simple string that contains information about an achievement. That information can be changed in the EDIT mode of the portlet with the help of AJAX controls.

There are two versions of the portlet in the repository:

* **achievement-portlet** - Simple version of the portlet developed solely with Wicket.
* **spring-achievement-portlet** - Version of the portlet that uses Spring Framework alongside with Wicket. Spring Framework is used for "dependency injection": service for loading the list of the prizes is injected into the EDIT mode page.

### Used versions

Example was developed using Apache Wicket 1.4.x and for Liferay Portal 6.0.6. The "spring-achievement-portlet" project depends on Spring Framework 3.0.5.

### How to run 

To run "achievement-portlet" project or "spring-achievement-portlet" project on Liferay you should add file 'build.custom.properties' to the root of the project's folder. This file will contain one single line:

    liferay.sdk.home=${LIFERAY_SDK_HOME}

where LIFERAY_SDK_HOME is the location of the Liferay Plugins SDK.

Then you should build the portlet project with Apache Ant.

### How to run on Liferay 6.1.x

You may try to run this example on Liferay 6.1.x as well. Just add the following line to the file 'docroot/WEB-INF/liferay-plugin-package.properties' in the project you're interested in:

    liferay-web-xml-enabled=false

## License

The Achievement Portlet example is licensed under the [MIT License](/shafranov/wicket-liferay-portlet/blob/master/LICENSE).
