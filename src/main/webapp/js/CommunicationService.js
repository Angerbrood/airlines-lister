var CommunicationService = new function () {
    this.successHandler = function (destination) {
        console.log("POST SUCCESS TO" + destination)
    };
    this.postData = function (destination, postData) {
        console.log("POST REQUEST TO " + destination + " with data: " + postData);
        console.log(JSON.stringify(postData));
        $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: destination,
            data: postData,
            async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false,    //This will force requested pages not to be cached by the browser
            processData:false, //To avoid making query String instead of JSON
            success: this.successHandler(destination)
        })
    };
};