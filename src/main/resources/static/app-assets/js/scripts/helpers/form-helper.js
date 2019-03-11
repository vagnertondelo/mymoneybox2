function getParamUrl() {
	var queries = {};
	$.each(document.location.search.substr(1).split('&'), function(c, q) {
		var i = q.split('=');
		try {
			queries[i[0].toString()] = i[1].toString();
		}catch {
			return null;
		}
	});
	return queries;
}