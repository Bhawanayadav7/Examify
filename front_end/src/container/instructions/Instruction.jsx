import React, { useState } from 'react';
import './instruction.css';
import { useLocation, useNavigate } from 'react-router-dom';

function Instruction() {
  const location = useLocation();
  const navigate = useNavigate();
  const testid = location.state.testid;
  const [continueChecked, setContinueChecked] = useState(false);
  const [showValidationError, setShowValidationError] = useState(false);

  const handleContinueCheckboxChange = () => {
    setContinueChecked(!continueChecked);
    if (showValidationError && !continueChecked) {
      setShowValidationError(false);
    }
  };

  function handleClick() {
    if (continueChecked) {
      navigate('/attempt', { state: { testid: testid } });
    } else {
      setShowValidationError(true);
    }
  }

  return (
    <div>
      <div className='Instruction'>
        <div className="user_inst_heading">Assessment Instructions</div>
        <div className="user_instructions">
          <ol>
            <li>
              <strong>Begin the Test:</strong> Click the "Attempt" button to initiate the assessment.
            </li>
            <li>
              <strong>Answer Selection:</strong> Ensure to select one answer for each question presented.
            </li>
            <li>
              <strong>Review Answers:</strong> Take the time to review your answers thoroughly before proceeding to submission.
            </li>
            <li>
              <strong>Submission:</strong> After answering all questions, click "Submit" to conclude the test.
            </li>
            <li>
              <strong>Independent Completion:</strong> Refrain from utilizing any external resources or seeking assistance from others during the assessment period.
            </li>
            <li>
              <strong>Focus and Concentration:</strong> Maintain focus and concentration to accurately respond to each question presented.
            </li>
            <li>
              <strong>Confidentiality:</strong> Maintain the confidentiality of assessment content and refrain from sharing questions or answers with others.
            </li>
          </ol>
        </div>
      </div>
      <div className="continue-checkbox-container">
        <input 
          type="checkbox" 
          id="continueCheckbox" 
          checked={continueChecked} 
          onChange={handleContinueCheckboxChange} 
        />
        <label htmlFor="continueCheckbox">I understand and want to continue</label>
      </div>
      {showValidationError && (
        <div className="validation-error" style={{ color: 'red', marginTop: '10px' }}>
          Please click on the checkbox to proceed.
        </div>
      )}
      <div className='next_btn_div'> 
        <button 
          type='button' 
          className='next_btn' 
          onClick={handleClick} 
          disabled={!continueChecked}
        >
          Next
        </button>
      </div>
    </div>
  );
}

export default Instruction;
