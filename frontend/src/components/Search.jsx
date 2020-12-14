import React, { useState, useEffect } from 'react';
import * as api from '../api'
import Results from './results/Results'

function Search(props) {

    const [results, setResult] = useState([])
    const [state, setState] = useState()
    const [city, setCity] = useState()
    const [hospital, setHospital] = useState()

    useEffect(() => {
        setState(props.state)
        setCity(props.city)
      }, [props.city, props.state])

    return (
        <div>
            <label htmlFor="state">Estado<input type="text" name="state" value={state} onChange={(event) => setState(event.target.value)}/></label>
            <label htmlFor="city">Município<input type="text" name="city" value={city} onChange={(event) => setCity(event.target.value)}/></label>
            <label htmlFor="hospital">Hospital<input type="text" name="hospital" value={hospital} onChange={(event) => setHospital(event.target.value)}/></label>
            <input type="button" value="buscar" onClick={() => {api.getReports(setResult, state, city, hospital)}} />
            <div>
                <Results results={results}/>
            </div>
        </div>
    )
}

export default Search