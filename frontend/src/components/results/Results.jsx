import './Results.css'

export default function Results(props) {

    const listItems = props.results.map(
        (item) => {
        return <li className="result" key={item.id}>
            <div>Estado: {item.state}</div>
            <div>Município: {item.city}</div>
            <div>Hospital: {item.hospitalName}</div>
            <div>Leitos de UTI COVID: {item.icuSARSBeds}</div>
            <div>Leitos ocupados: {item.occupiedIcuSARSBeds}</div>
            <div>Altas: {item.discharges}</div>
            <div>Mortes: {item.deaths}</div>
            <div>Data atualização: {item.lastModificationDate}</div>
        </li>}
    )

    return (
        <div>
            {listItems}
        </div>
    )
}
/*
id	"2017016"
state	"Amazonas"
stateAcronym	"AM"
city	"Humaitá"
hospitalNationalId	"2017016"
hospitalName	"HOSPITAL DR LUIZA DA CONCEICAO FERNANDES"
lastModificationDate	"2020-11-26T04:00:11.195"
respirators	1
clinicalBeds	46
icuBeds	0
clinicalSARSBeds	0
icuSARSBeds	0
occupiedClinicalBeds	0
occupiedIcuBeds	0
occupiedClinicalSARSBeds	5
occupiedIcuSARSBeds	0
discharges	2
deaths	0
*/