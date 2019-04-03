function floatToBrl(value) {
	return value.toLocaleString("pt-BR", { style: "currency" , currency:"BRL"});
}

function brlToFloat(value) {
    return isNaN(value) == false ? parseFloat(value) :   parseFloat(value.replace("R$","").replace(".","").replace(",","."));
}

function toFloat(value) {
	return isNaN(value) == false ? parseFloat(value) :   parseFloat( value.replace(".","").replace(",",".") );
}