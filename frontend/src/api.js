const axios = require('axios').default;

const reportClient = axios.create({
    baseURL: 'http://localhost:8080/api/v1'
})

export function getReports (callback, state, city, hospital) {
    let params = {
        state,
        city,
        hospital
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
    