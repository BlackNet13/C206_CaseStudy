# CCA Registration System
As you can see from the title of this repository this is one of the school projects I and my team had to work on, this project is suppose to emulate an agile project up to the end of sprint 1.

## Project Collaborators(including myself)
- [@BlackNet13](https://github.com/BlackNet13) (scrum master)
- [@ShouKang49](https://github.com/ShouKang49) (team member)
- [@AliyahSum](https://github.com/AliyahSum) (team member)
- [@masedryer](https://github.com/masedryer) (team member)
- [@MarcusAng-RP](https://github.com/MarcusAng-RP) (team member)
- [@Aesxli](https://github.com/Aesxli) (team member)

Below you can see the details for this project.

<hr>

## Task
#### Create a system on eclipse that allows 3 different type of users to perform functions relating to CCA activity registration.
We were provided a project description for this and have to ensure our system has CRUD functionality except for update which was written in documentation as the PBI for sprint 2 We are also expected to produce the relevant burndown chart, use case diagram, user stories and documentation required in an agile project. Additionally we also implemented Junit test cases and refactoring.

<table>
  <tr>
    <td>
       <img src="https://github.com/BlackNet13/C206_CaseStudy/assets/123053395/538168e2-9002-4caf-8221-e16efdef94bd" height ="500"/>
    </td>
  </tr>
  <tr>
    <td>Use Case Diagram</td>
  </tr>
</table>

<hr>

## Features
The features we needed to implement in sprint 1 includes:<br>
(Role: Admin)<br>
· Add a new user<br>
· View all users<br>
· Delete an existing user<br><br>

(Role: Teacher)<br>
· Add a new activity / Add a new time slot<br>
· View all activities / View all time slots<br>
· Delete an existing activity / Delete an existing time slot<br>
· View all registrations / View all approval status<br>
· Add a new approval status<br>
· Delete an existing registration / Delete an existing approval status<br>
· Add a new attendance<br>
· View all attendance<br>
· Delete an existing attendance<br><br>

(Role: Student)<br>
· Add a new registration<br>
· View all activities / View all time slots<br>
· View all registrations / View all approval status<br> 
· View all attendance<br><br>

<hr>

## Screenshots

### Final Product
<table>
  <tr>
    <td>
    <!--<img src="https://your-image-url.type" width="100" height="100">-->
  <img src="https://github.com/BlackNet13/C206_CaseStudy/assets/123053395/1f5263ab-850d-4146-b5ab-35f955eac29f" height ="150"/>
</td>
    <td>
      <img src="https://github.com/BlackNet13/C206_CaseStudy/assets/123053395/11b8f31a-8aa0-4f0a-9cd2-0e2b485faea4" height ="150"/>
    </td>
    </tr>
  <tr>
    <td>Login Menu</td> 
    <td>Admin Menu</td>
  </tr>
</table>

<table>
  <tr>
    <td>
  <img src="https://github.com/BlackNet13/C206_CaseStudy/assets/123053395/95418802-9e1c-4f0a-8f8c-818617b984d9" height ="150"/>

</td>
    <td>
      <img src="https://github.com/BlackNet13/C206_CaseStudy/assets/123053395/d0b05b04-da5f-4fa8-ae60-4e88a8d3aaae" height ="150"/>

    </td>
    </tr>
  <tr>
    <td>Teacher Menu</td> 
    <td>Student Menu</td>
  </tr>
</table>


## 🛠 Skills/Tools
Java, Eclipse, Github for version control, project cloning and merging.

## Lessons Learned
- It was a good idea to establish the flow of the system before beginning a group project, I implemented it through the code itself so that members could see it the first thing they get into the main code body.
- Discord pinning function works very well to keep our shared files for documentation always available for any team member to access them when needed.
- Some merge errors when working as a team are better fixed when in person as the error consist of merge being undone or overwriten by some of the undesired code, I believe the difficulty was due to this being our first ever agile project.
- Junit was tough as when we first implemented the main code, the code was built more for user input and thus when doing up the junit we had to modify the code so that it have a workaround that can work with both the user input and the junit itself.
