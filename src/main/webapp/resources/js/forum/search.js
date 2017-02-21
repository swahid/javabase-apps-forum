$(document).ready(function(e){
    $('#searchDiv .dropdown-menu').find('a').click(function(e) {
        e.preventDefault();
        
        var param = $(this).attr("href").replace("#","");
        var concept = $(this).text();
        $('#searchDiv span#search_concept').text(concept);
        $('#searchDiv .input-group #search_param').val(param);
        $('#searchBy').val(param);
    });
    
    
    
});