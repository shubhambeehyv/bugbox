$(document).ready(function(){
	
	
     $('.Issue').click(function(){
          $(this).children().toggle();
    });
    $('textarea').click(function(){return false;});
    
    $('.AddComment').click(function(){
       
        return false;
    
    });
});
function getReleaseId(){
	
	var pathArray = window.location.pathname.split( '=' );
	alert("In getRelease"+pathArray)
	return pathArray[1];
}

function addIssues(idRelease){
	alert(" In Addissues");
	jQuery.ajax({
		url:"issues?idRelease="+idRelease+"",
		method:"GET",
		contentType:"application/json",
		success:function(issues){
			var issuesArray = JSON.parse(issues);
			var $issuesContainer = $('.Issues');
			for(var j =0; j <issuesArray.length;j++){
			$issuesContainer.find('table')append('<tr ><td >'+issuesArray[j].issueTitle+'<div class="Comments"><textarea rows="5" cols="60"></textarea><div class="AddComment<button>Comment</button></div></div></td<td>'+issuesArray[j].issueAssigneeName+'</t<td>Solved</td></tr>');	
				
			}
		},
		error:function(){
			alert(" Issues error");
		}
				
	});
	
}
