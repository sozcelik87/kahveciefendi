function TranslateService($resource,$rootScope){
	console.log("Creating translate service");
	
	this.setLanguage = function(language){
		localStorage.setItem("language",language);
	};
	
	this.getLanguage = function(){
		if(localStorage.getItem("language")){
			return localStorage.getItem("language");
		}else{
			return "tr";
		}
	};
	
	this.setTranslateData = function() {
        var languageFilePath = 'resources/messages_' + this.getLanguage() + '.json';
        $resource(languageFilePath).get(function (data) {
            $rootScope.MESSAGES = data;
        });
    };
}

angular.module('kahveciEfendi').service('TranslateService',TranslateService);