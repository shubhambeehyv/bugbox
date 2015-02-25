<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"
	type="text/javascript"></script>
	<script src="facebox.js"></script>
        <link href="facebox.css" type="text/css" rel="stylesheet">
<script>

function addReleases(idProject){
	jQuery.ajax({
		url:"releases?idProject="+idProject+"",
		method:"GET",
		contentType:"application/json",
		success:function(releases){
			var releasesArray = JSON.parse(releases);
			var $releasesContainer = $('#'+idProject);
			for(var j =0; j <releasesArray.length;j++){
			$releasesContainer.append('<div class = "Release"><a href ="Issues.jsp?idRelease='+releasesArray[j].idRelease+'">'+releasesArray[j].releaseName+'</a></div>');	
				
			}
		},
		error:function(){
			alert(" Release error");
		}
				
	});
}
function addProjects(){
	
	jQuery.ajax({
		url:"projects",
		method:"GET",
		contentType:"application/json",
		success:function(projects){
			var projectsArray = JSON.parse(projects);
			var $projectContainer = $('#projects');
			for(var i = 0 ; i <projectsArray.length; i++ ){
			$projectContainer.append('<div class = "Project"><h1>'+projectsArray[i].projectName+'</h1><div class="Description">'+projectsArray[i].description+'</div><div class="Releases" id='+projectsArray[i].idProject+'></div>');
			var idProject = projectsArray[i].idProject;
			addReleases(idProject)
			
			
			}},
			
		
			error:function(){
				alert("Projects error");
			}
			
		});
			}
				


$(document).ready(function () {
	
	  addProjects();
	  $.facebox.settings.closeImage = 'closelabel.png';
		$.facebox.settings.loadingImage = 'loading.gif';
		 $('a[rel*=facebox]').facebox()
	  $('#AddProject').click(function(){showAddProject();});
	  
	});

</script>
<title>Projects</title>
<link href="styleSheet.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
</head>
<body>

	<div id="header">

		<img src="Bugbox.jpg" style="width: 35px; height: 35px"> <b>BugBox</b>
		<div id = "logout"><button> <a href="logout">Logout</a></button></div>
		<div id = "AddProject"><button ><a href ="addproject.html" rel="facebox">Add Project</a></button></div>
	</div>
	<div id="projects">
		<div class="Project">
			<h1>Project1</h1>
			<div class="Description">It describes the mathematical
				operation like addition,subtraction,multiplication and division.</div>
			<div class="Releases">
				<div class="Release">
					<a href="#">Release1.0</a>
				</div>

			</div>




		</div>
	</div>
</body>
</html>