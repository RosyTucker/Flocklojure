# Ask - Live Feedback

Repository for the London 'Ask' project, designed to allow audience members to give live feedback during events.


## Prerequisites

* You will need [Leiningen][1] 2.5.0 or above installed.  
* You will need [Java][1] (JDK)  
* If Using IntelliJ as your IDE you will need the [Cursive][3] plugin  _(remove other clojure plugins)_

## Running

To start a web server for the application, run:

    lein run
    
By default it will run on port `8080`


##Structure
The application uses Clojure on the backend and [Clostache][4] for templating.
[Http-kit][5] is used as the http-client and web sockets are utilised to handle the realtime communication.
 

[1]: https://github.com/technomancy/leiningen
[2]: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
[3]: https://cursiveclojure.com
[4]: https://github.com/fhd/clostache
[5]: http://http-kit.org
