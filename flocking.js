goog.addDependency("base.js", ['goog'], []);
goog.addDependency("../cljs/core.js", ['cljs.core'], ['goog.string', 'goog.object', 'goog.string.StringBuffer', 'goog.array']);
goog.addDependency("../flocking/utils.js", ['flocking.utils'], ['cljs.core']);
goog.addDependency("../flocking/core.js", ['flocking.core'], ['cljs.core', 'flocking.utils']);