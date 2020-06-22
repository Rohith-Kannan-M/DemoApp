<?php
 
  // if($_SERVER['REQUEST_METHOD']=='POST'){
  // echo $_SERVER["DOCUMENT_ROOT"];  // /home1/demonuts/public_html
//including the database connection file
    include_once("config.php");
	$response = array();
    $userid = $_POST['userid'];
	//$userid="17";	
	
	 	$query = mysqli_query($con, "SELECT * FROM courseregister WHERE userid='$userid'");
			
	        if(mysqli_num_rows($query) > 0){  
			while($row=mysqli_fetch_assoc($query)){
	        $query2 = mysqli_query($con,"SELECT * FROM courses WHERE courseid='".$row['courseid']."'");
			
			while($row2=mysqli_fetch_assoc($query2)){
			 
					
					
						array_push($response,
						array(
						'courseid' =>$row2['courseid'],
						'coursename' =>$row2['coursename'],
						'duration' =>$row2['duration'],
						'tutor' =>$row2['tutor'],
						'price' =>$row2['price'],
						'coursepic' =>$row2['coursepic'])
						);
					}
			}
	           echo json_encode($response);
	        }else{ 
	        	echo json_encode("No data");
	        }
	         mysqli_close($con);
	/* }else{
			echo json_encode("Error occured, please try again!") ;
	}*/
?>