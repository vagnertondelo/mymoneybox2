
var CACHE_NAME = 'sw-ex';
var CACHE_VERSION = 3.9;

var filesToCache = [
	 '/mymoneybox',
	 '/mymoneybox/freely/login',
	 'mymoneybox/freely/login?logout',
	 '/mymoneybox/dashboard',
	 
    '/mymoneybox/resources/app-assets/css/vendors.min.css',
    '/mymoneybox/resources/app-assets/vendors/css/forms/ichecks/icheck.css',
    '/mymoneybox/resources/app-assets/vendors/css/forms/ichecks/custom.css',
    '/mymoneybox/resources/app-assets/vendors/css/charts/jquery-jvectormap-2.0.3.css',
    '/mymoneybox/resources/app-assets/vendors/css/charts/morris.css',
    '/mymoneybox/resources/app-assets/fonts/simple-line-icons/style.min.css',
    '/mymoneybox/resources/app-assets/css/app.min.css',
    '/mymoneybox/resources/app-assets/css/core/menu/menu-types/vertical-menu-modern.css',
    '/mymoneybox/resources/app-assets/css/core/colors/palette-gradient.min.css',
    '/mymoneybox/resources/app-assets/css/pages/login-register.min.css',
    '/mymoneybox/resources/app-assets/vendors/css/extensions/toastr.css',
    '/mymoneybox/resources/app-assets/css/plugins/extensions/toastr.min.css',
    '/mymoneybox/resources/app-assets/vendors/css/extensions/sweetalert.css',
    '/mymoneybox/resources/app-assets/css/components.min.css',
    '/mymoneybox/resources/app-assets/fonts/line-awesome/css/line-awesome.min.css',
    '/mymoneybox/resources/app-assets/css/plugins/forms/extended/form-extended.min.css',
    '/mymoneybox/resources/app-assets/vendors/css/forms/select/select2.min.css',
    '/mymoneybox/resources/app-assets/css/plugins/forms/validation/form-validation.css'
];

self.oninstall = function(event) {
  event.waitUntil(
    caches.open(CACHE_NAME + '-v' + CACHE_VERSION).then(function(cache) {
    	console.log(event);
      return cache.addAll(filesToCache);
    })
  );
};

self.onactivate = function(event) {
  var currentCacheName = CACHE_NAME + '-v' + CACHE_VERSION;
  caches.keys().then(function(cacheNames) {
    return Promise.all(
    		
      cacheNames.map(function(cacheName) {
        if (cacheName.indexOf(CACHE_NAME) == -1) {
          return;
        }
        console.log("active" + event);
        if (cacheName != currentCacheName) {
          return caches.delete(cacheName);
        }
        
      })
    );
  });
};

self.onfetch = function(event) {
  var request = event.request;
  
  console.log("fetch " + request.url);
  
  event.respondWith(
    caches.match(request).then(function(response) {
      if (response) {
        return response;
      }
      return fetch(request).then(function(response) {
        var responseToCache = response.clone();
        caches.open(CACHE_NAME + '-v' + CACHE_VERSION).then(
          function(cache) {
            cache.put(request, responseToCache).catch(function(err) {
            	
              console.warn(request.url + ': ' + err.message);
            });
          });
        return response;
      });
    })
  );
};


