Feature: Login feature

  Scenario Outline: Test Login con usuario y pswd validos
    Given El usuario accede a Login page
    When El usuario ingresa <username> and <password>
    And Click en boton login
    Then El usuario accede al dashboard

    Examples: 
      | username | password |
      | owner.owner@yopmail.com| n697PlRJvmm3hDn8c4GXEw== |