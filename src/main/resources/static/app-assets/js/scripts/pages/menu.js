var obj = $(mi);

$(document).ready(function(){
	blackBG(obj)
	getListParent(obj);
})

function blackBG(obj) {
	if(obj.parent().hasClass('nav-item')) {
		obj.parent().addClass('active')
	} else {
		obj.parent().addClass('active')
	}
}

function getListParent(obj) {
	if (obj.hasClass('nav-item')) {
		obj.addClass('open')
		return 0;
	}
	return getListParent(obj.parent())
}
