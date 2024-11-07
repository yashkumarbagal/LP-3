// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

// Contract to manage student data
contract StudentData {

    // Structure to store student details
    struct Student {
        int ID;
        string fName;
        string lName;
    }

    // State variables
    address public owner;
    int public stdCount = 0;
    mapping(int => Student) public stdRecords;

    // Modifier to allow only the owner to execute certain functions
    modifier onlyOwner {
        require(owner == msg.sender, "Only the owner can execute this function");
        _;
    }

    // Constructor to set the contract deployer as the owner
    constructor() {
        owner = msg.sender;
    }

    // Function to add new student records, restricted to the owner
    function addNewRecords(int _ID, string memory _fName, string memory _lName) public onlyOwner {
        // Increase the student count
        stdCount += 1;

        // Add the new student record
        stdRecords[stdCount] = Student(_ID, _fName, _lName);
    }
}
