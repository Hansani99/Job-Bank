$(function() {
    $(document).ready(function() {
        $("#btnSearch").click(function() {
            const reqObj = {
                "title": $("#jobTitle").val(),
                "companyName": $("#companyName").val(),
                "jobType": parseInt($("#jobType").val()),
                "industry": parseInt($("#industry").val()),
                "expLevel": parseInt($("#expLevel").val())
            };$.ajax({
                url: "http://localhost:8082/jobseeker/search/jobs",
                method: "POST",
                data: JSON.stringify(reqObj),
                dataType: 'json',
                contentType: "application/json"

            }).then(function(data) {
            $('#tblSearchResult tr:gt(0)').remove()

                data.jobSearchResults.forEach(element =>
                //console.log(element);
                $('#tblSearchResult').append('<tr> <td>' + element.datePosted + '</td>  <td>' + element.title + '</td> <td>' + element.companyName + '</td> <td>' + element.jobType.name + '</td> <td>' + element.industry.name + '</td> <td>' + element.experianceLevel.name + '</td> <td> <button type="button" class="btn btn-success" onclick="openRequestedPopup('+element.id+')")">View</button> </td></tr>')
                );
            });
        });
    });





});

function openRequestedPopup(id) {
   window.open(window.location.origin+'/jobseeker/viewJob?jobId='+id, "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=1000,left=1000,width=1000,height=1000");
  //console.log(window.location.origin+'/jobseeker/viewJob?jobId='+id);
}