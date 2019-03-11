function mask() {
	$('.phonebr').mask('(00) 00000-0000');
	$('.phonepr').mask('(00) 000-000');
	$('.phonebrpr').mask('(00) 000000000000');
	$(".cep").mask("99.999-999");
	$('.date').mask('00/00/0000');
	$('.cnpj').mask('00.000.000/0000-00', {
		reverse : true
	});

	$('.cpf').mask('000.000.000-00', {
		reverse : true
	});
}