const axios = require('axios').default

let serverURL = process.env.NODE_ENV == 'production'? window.location.protocol +'//'+ window.location.host : 'http://localhost:8080'

const reportClient = axios.create({
    baseURL: serverURL + '/api/v1'
})

export function getReports (callback, state, city, hospital, fromDate) {
    let params = {
        state,
        city,
        hospital,
        fromDate
    }
    reportClient.get('/bedreports', {
        params
    })
    .then(function (response) {
        return callback(response.data)
    })
    .catch(function (error) {
        console.log(error)
    })
    .then(function () {
        console.log('report search called')
    })
}

const geoLocationClient = axios.create({
    baseURL: 'https://api.bigdatacloud.net/data/reverse-geocode-client'
})

export function getLocation (callback, latitude, longitude) {
    let params = {latitude, longitude}
    geoLocationClient.get('/', {
        params
    }).then(function(response) {
        let {city, principalSubdivision} = response.data
        return callback({city, state: principalSubdivision})
    }).then(function(error) {
        console.log(error)
    }).then(function(){
        console.log('geolocation called')
    })
}

//localityLanguage=en
    