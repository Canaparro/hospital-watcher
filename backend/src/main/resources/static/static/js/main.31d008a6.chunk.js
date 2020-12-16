(this["webpackJsonphospital-watcher"]=this["webpackJsonphospital-watcher"]||[]).push([[0],{19:function(t,e,c){},20:function(t,e,c){},39:function(t,e,c){},40:function(t,e,c){},41:function(t,e,c){"use strict";c.r(e);var n=c(0),a=c(2),i=c.n(a),s=c(13),o=c.n(s),r=(c(19),c(3)),l=(c(20),c(21).default),u=l.create({baseURL:"http://localhost:8080/api/v1"});function d(t,e,c,n){var a={state:e,city:c,hospital:n};u.get("/bedreports",{params:a}).then((function(e){return t(e.data)})).catch((function(t){console.log(t)})).then((function(){console.log("report search called")}))}var j=l.create({baseURL:"https://api.bigdatacloud.net/data/reverse-geocode-client"});c(39);function h(t){var e=t.results.map((function(t){return Object(n.jsxs)("li",{className:"result",children:[Object(n.jsxs)("div",{children:["Estado: ",t.state]}),Object(n.jsxs)("div",{children:["Munic\xedpio: ",t.city]}),Object(n.jsxs)("div",{children:["Hospital: ",t.hospitalName]}),Object(n.jsxs)("div",{children:["Leitos de UTI COVID: ",t.icuSARSBeds]}),Object(n.jsxs)("div",{children:["Leitos ocupados: ",t.occupiedIcuSARSBeds]}),Object(n.jsxs)("div",{children:["Altas: ",t.discharges]}),Object(n.jsxs)("div",{children:["Mortes: ",t.deaths]}),Object(n.jsxs)("div",{children:["Data atualiza\xe7\xe3o: ",t.lastModificationDate]})]},t.id)}));return Object(n.jsx)("div",{children:e})}c(40);var b=function(t){var e=Object(a.useState)([]),c=Object(r.a)(e,2),i=c[0],s=c[1],o=Object(a.useState)(),l=Object(r.a)(o,2),u=l[0],j=l[1],b=Object(a.useState)(),p=Object(r.a)(b,2),O=p[0],f=p[1],v=Object(a.useState)(),g=Object(r.a)(v,2),x=g[0],m=g[1];return Object(a.useEffect)((function(e,c){j(t.state),f(t.city),d(s,c,e,null)}),[t.city,t.state]),Object(n.jsxs)("div",{className:"search-grouper",children:[Object(n.jsxs)("label",{children:["Estado",Object(n.jsx)("input",{type:"text",name:"state",value:u,onChange:function(t){return j(t.target.value)}})]}),Object(n.jsxs)("label",{children:["Munic\xedpio",Object(n.jsx)("input",{type:"text",name:"city",value:O,onChange:function(t){return f(t.target.value)}})]}),Object(n.jsxs)("label",{children:["Hospital",Object(n.jsx)("input",{type:"text",name:"hospital",value:x,onChange:function(t){return m(t.target.value)}})]}),Object(n.jsx)("button",{onClick:function(){d(s,u,O,x)},children:"Buscar"}),Object(n.jsx)("div",{children:Object(n.jsx)(h,{results:i})})]})};var p=function(){var t=Object(a.useState)(""),e=Object(r.a)(t,2),c=e[0],i=e[1];return Object(a.useEffect)((function(){navigator.geolocation&&navigator.geolocation.getCurrentPosition((function(t){!function(t){!function(t,e,c){var n={latitude:e,longitude:c};j.get("/",{params:n}).then((function(e){var c=e.data,n=c.city,a=c.principalSubdivision;return t({city:n,state:a})})).then((function(t){console.log(t)})).then((function(){console.log("geolocation called")}))}(i,t.coords.latitude,t.coords.longitude)}(t)}),(function(t){return alert(t.message)}),{timeout:2e3})}),[]),Object(n.jsxs)("div",{className:"App",children:[Object(n.jsxs)("header",{className:"App-header",children:[Object(n.jsx)("h1",{children:"Hospital Watcher"}),Object(n.jsx)("p",{children:"Este \xe9 um site para buscar informa\xe7\xf5es de ocupa\xe7\xe3o de leitos em hospitais. A informa\xe7\xe3o provida \xe9 de responsabilidade do governo."})]}),Object(n.jsx)(b,{city:c.city,state:c.state})]})},O=function(t){t&&t instanceof Function&&c.e(3).then(c.bind(null,42)).then((function(e){var c=e.getCLS,n=e.getFID,a=e.getFCP,i=e.getLCP,s=e.getTTFB;c(t),n(t),a(t),i(t),s(t)}))};o.a.render(Object(n.jsx)(i.a.StrictMode,{children:Object(n.jsx)(p,{})}),document.getElementById("root")),O()}},[[41,1,2]]]);
//# sourceMappingURL=main.31d008a6.chunk.js.map