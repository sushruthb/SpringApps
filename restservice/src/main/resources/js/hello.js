$(document).ready(function() {
    $.ajax({
        url: "http://10.76.110.207:7676/demo/all"
    }).then(function(data) {
       $('.demo-all-id').append(data.id);
       $('.demo-all-name').append(data.name);
       $('.demo-all-email').append(data.email);
    });
});