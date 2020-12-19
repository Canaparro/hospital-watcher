import React, { useState, useEffect } from 'react';
import * as api from '../../api'
import Results from '../results/Results'
import './Search.css'

function Search(props) {

    const [results, setResult] = useState([])
    const [state, setState] = useState()
    const [city, setCity] = useState()
    const [hospital, setHospital] = useState()

    useEffect((city, state) => {
        setState(props.state)
        setCity(props.city)
        api.getReports(setResult, state, city, null)
    }, [props.city, props.state])

    function getFromDate() {
        let now = new Date()
        let fromDate = now
        fromDate.setDate(now.getDate() + 1)
        return fromDate.toISOString().replace('Z', '')
    }

    return (
        <div className='search-grouper'>
            <label>Estado<input type="text" name="state" value={state} onChange={(event) => setState(event.target.value)}/></label>
            <label>Município<input type="text" name="city" value={city} onChange={(event) => setCity(event.target.value)}/></label>
            <label>Hospital<input type="text" name="hospital" value={hospital} onChange={(event) => setHospital(event.target.value)}/></label>
            <button onClick={() => {api.getReports(setResult, state, city, hospital, getFromDate())}}>Buscar</button>
            <div>
                <Results results={results}/>
            </div>
        </div>
    )
}

export default Search