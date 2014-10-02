(ns ask.test.routes
  (:require [clojure.test :refer :all]
            [ask.routes :refer :all]
            [ring.mock.request :as mock]
            [ask.templates :as templates]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) (templates/render-template "home" {:name "Rosy"})))))
  
  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
