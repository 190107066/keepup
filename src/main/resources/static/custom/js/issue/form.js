$(document).ready(function() {
	
	$('#saveBtn').on('click', function(){
		var errors = validate();
		if( errors.length > 0 ) {
			$('.errors-modal').find('.modal-body').html( errors.join('<br />') );
			$('.errors-modal').modal('show');
		} else {
			var issue = {
					books: getIssuedBookIds().join()
			}
			$.post( "/rest/issue/save", issue).done(function (data){
				if( data=='success' ) {
					window.location = '/issue/new';
				}
			});
		}
	});
	
	function getIssuedBookIds() {
		var ids = [];
		for(var k=0 ; k<booksToIssue.length ; k++) {
			ids.push( booksToIssue[k].id );
		}
		return ids;
	}
	
	function validate() {
		var errors = []
		if( booksToIssue.length == 0 ) {
			errors.push('- Add Books to issue');
		}
		return errors;
	}
	
});

var booksToIssue = [];

function initBooksInTable() {
	
	var trs = '';
	for( var k=0 ; k<booksToIssue.length ; k++ ) {
		var rowNum = k+1;
		trs += '<tr>';
		trs += '<td>'+rowNum+'</td>';
		trs += '<td>'+booksToIssue[k].tag+'</td>';
		trs += '<td>'+booksToIssue[k].title+'</td>';
		trs += '<td>'+booksToIssue[k].authors+'</td>';
		trs += '<td><a href="javascript:void(0)"  onclick="removeFromTable('+rowNum+', '+booksToIssue[k].id+')"><i class="fa fa-remove"></i></a></td>';
		trs += '</tr>';
	}
	$("#issueBooksTable").find("tr:gt(0)").remove();
	$('#issueBooksTable').append( trs );
}

function removeFromTable(rowNum, id) {
	$('#issueBooksTable tr:eq('+(rowNum)+')').remove();
	removeFromBooksIssuedList(id);
	initBooksInTable();
}

function removeFromBooksIssuedList(id) {
	for( var k=0 ; k<booksToIssue.length ; k++ ) {
		if( booksToIssue[k].id == id ) {
			booksToIssue.splice(k, 1);
			break;
		}
	}
}