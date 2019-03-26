class Cep {
    constructor() {}

    getCepData(zipCode) {
    	return new Promise((r) => {
    		zipCode = zipCode.replace(/\D/g,'');
    		$.ajax({
    			type : "GET",
    			url : "https://api.postmon.com.br/v1/cep/" + zipCode,
    			success : function(zipCodeObj) {
    				r(zipCodeObj)
    			},
    			error: function (request, status, error) {
    		        console.log(request)
    		    }
    		})
    	});
    }
}