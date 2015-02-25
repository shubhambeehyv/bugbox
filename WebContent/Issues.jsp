<html>

<head>
<!-- Bring to you by http://www.CSSTableGenerator.com -->
<link href="Issues.css" rel="stylesheet" type="text/css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
function getUrlParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}

function addButton(){
	var comment = $(this).parent().find('textarea').val();
	var idIssue = $(this).parent().attr('id'); 
	
	jQuery.ajax({
		url:"comments",
		method:"POST",
		data:{comment:'Hey new Comment2',idIssue:'1'},
		
		success:function(){
			location.reload();
		},
		error:function(){
			alert("Error adding comment");
		}
	});
}

function addRelease(){
	jQuery.ajax({
		url:"releases?idRelease="+getUrlParameter("idRelease")+"",
		method:"GET",
		contentType:"application/json",
		success:function(release){
			var release = JSON.parse(release);
			var $releaseContainer = $('#release');
			$releaseContainer.append('<b>'+release.releaseName+'</b><div id="releaseDescription">'+release.releaseDescription+'</div>')
		}
	});
}
function addComments(idIssue){
	jQuery.ajax({
		url:"comments?idIssue="+idIssue,
		method:"GET",
		contentType:"application/json",
		success:function(comments){
			alert("Add Comment Success")
			var commentsArray = JSON.parse(comments);
			var commentsContainer = $('#'+idIssue);
			for(var i =0;i<commentsArray.length;i++ ){
			commentsContainer.append('<div class="comment">'+commentsArray[i].comment+'</div>')}
			commentsContainer.append('<textarea rows="5" cols="60"></textarea><div class="AddComment"> <button>Comment</button></div>') 
			$('.AddComment').click(function(){
				addButton();
			});
			 $('textarea').click(function(){return false;});
		},
		error: function(){
			alert("Comments Error")
		}
	});
}
$(document).ready(function(){
	 
	$('#header').click(function(){
        window.location.replace("Projects.jsp");
  });
	addRelease();
	jQuery.ajax({
		url:"issues?idRelease="+getUrlParameter("idRelease")+"",
		method:"GET",
		contentType:"application/json",
		success:function(issues){
			var issuesArray = JSON.parse(issues);
			var $issuesContainer = $('.Issues');
			for(var j =0; j <issuesArray.length;j++){
			$issuesContainer.find('table').append('<tr ><td class="Issue" >'+issuesArray[j].issueTitle+'<div id="'+issuesArray[j].idIssue+'"></div></td><td>'+issuesArray[j].issueAssigneeName+'</td><td>'+issuesArray[j].issueStatus+'</td></tr>');
			addComments(issuesArray[j].idIssue);
			$('.Issue').children().css("display","none");	
			$('.Issue').click(function(){
					$(this).children().toggle();
				});
			}
		},
		error:function(){
			alert(" Issues error");
		}
				
	});
	
	
	
});


	
</script>
</head>

<body>
	<div id="header">
		<div id="logout"><button> <a href="logout">Logout</a></button></div>

		<img src="Bugbox.jpg" style="width: 35px; height: 35px"> <b>BugBox</b>

	</div>
	<div id="release"></div>


	<div class="Issues">
		<table>
			<tr>
				<td>Issue</td>
				<td>Assignee</td>
				<td>Status</td>
			</tr>

			<tr>
				<td class="Issue">Issue 1


					<div class="Comments">
						<div class="comment">Comment#1</div>
						<div class="comment">Comment#2</div>


						<textarea rows="5" cols="60"></textarea>



						<div class="AddComment">
							<button>Comment</button>
						</div>
					</div>

				</td>
				<td>Assignee 1</td>
				<td>Solved</td>

			</tr>





		</table>
	</div>


</body>

</html>
