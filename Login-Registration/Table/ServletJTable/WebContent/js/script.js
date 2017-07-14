/**
 * jTable Load Data Code 
 */
$(document).ready(function() {
	$('#StudentTableContainer').jtable({
		title : 'Students List',
		actions : {
			listAction : 'Student'
		},
		fields : {
			studentId : {
				title : 'Id',
				width : '30%',
				key : true,
				list : true,
				create : true
			},
			studentName : {
				title : 'Name',
				width : '30%',
				edit : false
			},
			department : {
				title : 'Department',
				width : '30%',
				edit : true
			}
		}
	});
	$('#StudentTableContainer').jtable('load');
});