import './App.css'
import Search from './components/search/Search'
import * as api from './api'
import React, { useState, useEffect } from 'react'

function App() {

  const [location, setLocation] = useState("")
  
  useEffect(() => {
    function geoLocation() {
      if(navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(getGeolocation, error)
      }
    }

    function error(positionError) {
      console.log(positionError)
    }
  
    function getGeolocation(position) {
      api.getLocation(setLocation, position.coords.latitude, position.coords.longitude)
    }

    geoLocation()
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <h1>Hospital Watcher</h1>
        <p>
          Este é um site para buscar informações de ocupação de leitos em hospitais. 
          A informação provida é de responsabilidade do governo.
        </p>
      </header>
      <Search city={location.city} state={location.state}/>
    </div>
  );
}

export default App;
