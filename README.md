# Boilerplate Compojure/Clostache

A Boilerplate project for creating a web app using [Compojure][1] and [Clostashe][2]

## Prerequisites
* You will need [Leiningen][1] 2.5.0 or above installed.
* You will need [Java][1] (JDK).
* If using IntelliJ as your IDE you will need the [Cursive][3] plugin  _(remove other clojure plugins)_

## Running

To start a web server for the application, run:

    lein run
    
To access the site, go to your browser and open up `http://localhost:8080`.

## Structure

The application uses Clojure on the back-end and a standard mixture of HTML/CSS/JS on the front-end. [Http-kit][5] is used as the http-client.

### Templating

In order to create views, the application uses [Clostache][4] to generate views. Views exist in the `resources/templates/` folder and end in `.tash.html`. Wrapping named variables in moustaches (e.g. `{{name}}`) allows them to be filled in later; for example:

**resources/templates/my-template.tash.html**
```html
<h1>{{first_name}} {{last_name}}</h1>
```

**Your Clojure Code**
```clojure
(require [example-namespace.templates :as templates])

(templates/render-template "home" {:first_name "Jimmy" :last_name "Thompson"})
```

**Result**
```html
<h1>Jimmy Thompson</h1>
```

## Deploying to Heroku

In order to deploy to Heroku you will need to add a proc file with the following content:  

    web: lein run -m main $PORT

[1]: https://github.com/technomancy/leiningen
[2]: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
[3]: https://cursiveclojure.com
[4]: https://github.com/fhd/clostache
[5]: http://http-kit.org
