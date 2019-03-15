function realToNumber(value){
    if(value === ""){
    	value =  0;
    }else{
    	value = value.replace(".","");
    	value = value.replace(",",".");
    	value = parseFloat(value);
    }
    return value;
}