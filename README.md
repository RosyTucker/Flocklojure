# Ask - Live Feedback

Staging: http://ask-staging.herokuapp.com

[![Build Status](https://travis-ci.org/London-Beach/ask.svg?branch=master)](https://travis-ci.org/London-Beach/ask)

Production: http://ask-production.herokuapp.com

[![Build Status](https://travis-ci.org/London-Beach/ask.svg?branch=production)](https://travis-ci.org/London-Beach/ask)

Repository for the London 'Ask' project, designed to allow audience members to give live feedback during events. The app is currently available at http://ask-staging.herokuapp.com.

## Prerequisites

* You will need [Leiningen][1] 2.5.0 or above installed.
* You will need [Java][1] (JDK).
* If using IntelliJ as your IDE you will need the [Cursive][3] plugin  _(remove other clojure plugins)_

## Running

To start a web server for the application, run:

    lein run
    
To access the site, go to your browser and open up `http://localhost:8080`.

## Structure

The application uses Clojure on the back-end and a standard mixture of HTML/CSS/JS o nthe front-end. [Http-kit][5] is used as the http-client and web sockets are utilised to handle the realtime communication.

### Templating

In order to create views, the application uses [Clostache][4] to generate views. Views exist in the `resources/templates/` folder and end in `.tash.html`. Wrapping named variables in moustaches (e.g. `{{name}}`) allows them to be filled in later; for example:

**resources/templates/my-template.tash.html**
```html
<h1>{{first_name}} {{last_name}}</h1>
```

**Your Clojure Code**
```clojure
(require [ask.templates :as templates])

(templates/render-template "home" {:first_name "Jimmy" :last_name "Thompson"})
```

**Result**
```html
<h1>Jimmy Thompson</h1>
```

[1]: https://github.com/technomancy/leiningen
[2]: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
[3]: https://cursiveclojure.com
[4]: https://github.com/fhd/clostache
[5]: http://http-kit.org
